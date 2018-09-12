package com.funny.blood.server.robot;

import com.funny.blood.server.robot.net.GateClient;
import com.funny.blood.AbstractShutdownHooks;
import com.google.inject.Inject;

public class RobotShutdownHooks extends AbstractShutdownHooks {
  private final GateClient gateClient;

  @Inject
  public RobotShutdownHooks(GateClient gateClient) {
    this.gateClient = gateClient;
  }

  @Override
  protected void shutdown() {
    shutdown(
        () -> {
          try {
            gateClient.shutdown();
          } catch (InterruptedException e) {
            logger.error("", e);
          }
        },
        "gate client");
  }
}
