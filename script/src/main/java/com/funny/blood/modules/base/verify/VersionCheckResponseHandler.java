package com.funny.blood.modules.base.verify;

import com.funny.blood.modules.handler.GateToClientHandler;
import com.funny.blood.net.robot.RobotUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VersionCheckResponseHandler implements GateToClientHandler<VersionCheckResponse> {
  private static final Logger logger = LoggerFactory.getLogger(VersionCheckResponseHandler.class);

  @Override
  public void exec(RobotUser user, VersionCheckResponse message) {
    logger.info("version check suc");
    user.write(new LoginRequest(user.getUsername()));
  }
}
