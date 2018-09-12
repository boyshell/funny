package com.funny.blood.server.gate;

import com.funny.blood.server.gate.net.GateServer;
import com.funny.blood.AbstractShutdownHooks;
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
