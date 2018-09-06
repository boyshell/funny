package com.funny.blood.modules.base.net;

import com.funny.blood.modules.handler.GateToClientHandler;
import com.funny.blood.net.robot.RobotUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KickRequestHandler implements GateToClientHandler<KickRequest> {
  private static final Logger logger = LoggerFactory.getLogger(KickRequestHandler.class);

  @Override
  public void exec(RobotUser user, KickRequest message) {
    logger.info("kick:{}", message.getType().name());
  }
}
