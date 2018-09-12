package com.funny.blood.server.hall;

import com.funny.blood.server.hall.net.HallServer;
import com.funny.blood.AbstractShutdownHooks;
import com.google.inject.Inject;

public class HallShutdownHooks extends AbstractShutdownHooks {
  private final HallServer hallServer;

  @Inject
  public HallShutdownHooks(HallServer hallServer) {
    this.hallServer = hallServer;
  }

  @Override
  protected void shutdown() {
    shutdown(() -> hallServer.shutdown(), "shutdown hall server");
  }
}
