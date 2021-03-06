package com.funny.blood.server.room;

import com.funny.blood.server.room.net.HallClient;
import com.funny.blood.server.room.net.RoomServer;
import com.funny.blood.AbstractShutdownHooks;
import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RoomShutdownHooks extends AbstractShutdownHooks {
  private static final Logger logger = LoggerFactory.getLogger(RoomShutdownHooks.class);
  private final RoomServer roomServer;
  private final HallClient hallClient;

  @Inject
  public RoomShutdownHooks(RoomServer roomServer, HallClient hallClient) {
    this.roomServer = roomServer;
    this.hallClient = hallClient;
  }

  @Override
  protected void shutdown() {
    shutdown(() -> roomServer.shutdown(), "shutdown room server");
    shutdown(
        () -> {
          try {
            hallClient.shutdown();
          } catch (InterruptedException e) {
            logger.error("", e);
          }
        },
        "shutdown hall client");
  }
}
