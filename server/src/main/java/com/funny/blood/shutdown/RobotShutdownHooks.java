package com.funny.blood.shutdown;

import com.funny.blood.net.robot.GateClient;
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
