package com.funny.blood.shutdown;

import com.funny.blood.net.hall.HallServer;
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
