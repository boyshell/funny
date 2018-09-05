package com.funny.blood.shutdown;

import com.funny.blood.net.gate.GateServer;
import com.google.inject.Inject;

public class GateShutdownHooks extends AbstractShutdownHooks {
  private final GateServer gateServer;

  @Inject
  public GateShutdownHooks(GateServer gateServer) {
    this.gateServer = gateServer;
  }

  protected void shutdown() {
    logger.info("shutdown...");
    shutdown(() -> gateServer.shutdown(), "gate server");
    logger.info("shutdown suc");
  }
}
