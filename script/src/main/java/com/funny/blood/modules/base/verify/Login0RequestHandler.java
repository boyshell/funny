package com.funny.blood.modules.base.verify;

import com.funny.blood.modules.base.user.UserModule;
import com.funny.blood.modules.handler.GateToLoginHandler;
import com.funny.blood.modules.user.login.User;
import com.funny.blood.net.login.ClientToLoginUser;
import com.funny.blood.net.login.GateToLoginUser;
import com.funny.blood.net.login.LoginServer;
import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shell.time.TimeUtil;

import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;

public class Login0RequestHandler implements GateToLoginHandler<Login0Request> {
  private static final Logger logger = LoggerFactory.getLogger(Login0RequestHandler.class);
  private final UserModule userModule;
  private final LoginServer loginServer;

  @Inject
  public Login0RequestHandler(UserModule userModule, LoginServer loginServer) {
    this.userModule = userModule;
    this.loginServer = loginServer;
  }

  @Override
  public void exec(GateToLoginUser netUser, Login0Request message) {
    ClientToLoginUser clientUser = netUser.getClientUsers().get(message.getChannelID());
    if (clientUser != null) {
      logger.error("client user is not null:{}", message);
      netUser.closeAndForward(message.getChannelID(), LoginError.SYSTEM, "system");
      return;
    }
    // todo 合法性验证,token等等
    User user = userModule.getUser(message.getAccount());
    if (user == null) {
      user = create(message.getAccount());
    }
    // 可能创建失败，因为可能多个同时创建的情况，那么只会有一个被成功创建
    if (user == null) {
      logger.error("create user fail!{}", message);
      netUser.closeAndForward(message.getChannelID(), LoginError.REPLACE, "replace");
      return;
    }
    clientUser =
        new ClientToLoginUser(
            netUser.getChannel(),
            Thread.currentThread(),
            message.getChannelID(),
            new WeakReference<>(user));
    netUser.getClientUsers().put(message.getChannelID(), clientUser);

    User finalUser = user;
    ClientToLoginUser finalClientUser = clientUser;
    user.getClientDoor()
        .tryOpen(
            clientUser,
            () -> {
              // todo 避免内存泄漏，clientUser也加一个超时处理?
              finalClientUser.forward(
                  new LoginResponse(finalUser.getId(), message.getTime(), TimeUtil.millis()));
              loginServer.broadcast(new LockUserRequest(message.getChannelID(), finalUser.getId()));
            },
            () -> logger.error("can not get the door!", finalUser));
  }

  private final AtomicInteger idGen = new AtomicInteger(1); // todo 持久化

  private User create(String username) {
    User user = new User(idGen.incrementAndGet(), username);

    if (userModule.add(user)) {
      return user;
    } else {
      return null;
    }
  }
}
