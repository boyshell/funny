package com.funny.blood.modules.base.verify;

import com.funny.blood.modules.handler.GateToClientHandler;
import com.funny.blood.net.robot.RobotUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

public class LoginErrorHandler implements GateToClientHandler<LoginError> {
  private static final Logger logger = LoggerFactory.getLogger(LoginErrorHandler.class);

  private final AtomicInteger count = new AtomicInteger();

  @Override
  public void exec(RobotUser user, LoginError message) {
    logger.error("login fail count:{}", count.incrementAndGet());
  }
}
