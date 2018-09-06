package com.funny.blood.modules.base.verify;

import com.funny.blood.modules.handler.GateToClientHandler;
import com.funny.blood.net.robot.RobotUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shell.net.NetUtil;

import java.util.concurrent.atomic.AtomicInteger;

public class LoginResponseHandler implements GateToClientHandler<LoginResponse> {
  private static final Logger logger = LoggerFactory.getLogger(LoginResponseHandler.class);
  private final AtomicInteger count = new AtomicInteger();

  @Override
  public void exec(RobotUser user, LoginResponse message) {
    logger.info("login suc count:{}", count.incrementAndGet());
    NetUtil.close(user.getChannel(), "login suc");
  }
}
