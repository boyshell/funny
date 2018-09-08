package com.funny.blood.modules.base.verify;

import com.funny.blood.modules.base.user.login.UserInLoginModule;
import com.funny.blood.modules.handler.GateToLoginHandler;
import com.funny.blood.modules.user.login.UserInLogin;
import com.funny.blood.net.login.ClientToLoginUser;
import com.funny.blood.net.login.GateToLoginUser;
import com.funny.blood.net.login.LoginServer;
import com.funny.blood.utils.Null;
import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.ref.WeakReference;

public class GetUserIDRequestHandler implements GateToLoginHandler<GetUserIDRequest> {
  private static final Logger logger = LoggerFactory.getLogger(GetUserIDRequestHandler.class);
  private final UserInLoginModule userInLoginModule;
  private final LoginServer loginServer;

  @Inject
  public GetUserIDRequestHandler(UserInLoginModule userInLoginModule, LoginServer loginServer) {
    this.userInLoginModule = userInLoginModule;
    this.loginServer = loginServer;
  }

  @Override
  public void exec(GateToLoginUser netUser, GetUserIDRequest message) {
    logger.info("rcv get user id msg:{}", message);
    ClientToLoginUser clientUser = netUser.getClientUsers().get(message.getChannelID());
    if (clientUser != null) {
      logger.error("client user is not null:{}", message);
      netUser.write(new GetUserIDResponse(message.getChannelID(), Null.ID, GetUserIDError.SYSTEM));
      return;
    }
    // todo 合法性验证,token等等放到gate处理
    UserInLogin user = userInLoginModule.getUser(message.getAccount());
    if (user == null) {
      user = create(message.getAccount());
    }
    // 可能创建失败，因为可能多个同时创建的情况，那么只会有一个被成功创建
    if (user == null) {
      logger.error("create user fail!{}", message);
      netUser.write(
          new GetUserIDResponse(message.getChannelID(), user.getId(), GetUserIDError.REPLACE));
      return;
    }
    clientUser =
        new ClientToLoginUser(
            netUser.getChannel(),
            Thread.currentThread(),
            message.getChannelID(),
            new WeakReference<>(user));
    netUser.getClientUsers().put(message.getChannelID(), clientUser);

    UserInLogin finalUser = user;
    user.tryOpen(
        clientUser,
        () -> {
          // todo 避免内存泄漏，clientUser也加一个超时处理?
          loginServer.broadcast(
              new GetUserIDResponse(message.getChannelID(), finalUser.getId(), null));
        },
        () -> {
          logger.error("can not get the door!", finalUser);
          netUser.write(
              new GetUserIDResponse(
                  message.getChannelID(), finalUser.getId(), GetUserIDError.SYSTEM));
        });
  }

  private UserInLogin create(String username) {
    Long id = userInLoginModule.newUserID();
    if (id > Integer.MAX_VALUE) {
      logger.error("int overflow:{}", username, new IllegalArgumentException());
      return null;
    }

    UserInLogin user = new UserInLogin(id.intValue(), username);
    if (userInLoginModule.add(user)) {
      return user;
    } else {
      return null;
    }
  }
}
