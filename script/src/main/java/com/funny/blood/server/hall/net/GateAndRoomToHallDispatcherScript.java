package com.funny.blood.server.hall.net;

import com.funny.blood.net.IDispatcherScript;
import com.google.inject.Inject;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shell.net.Message;

public class GateAndRoomToHallDispatcherScript implements IDispatcherScript {
  private static final Logger logger =
      LoggerFactory.getLogger(GateAndRoomToHallDispatcherScript.class);
  private final GateAndRoomToHallHandlerGroup handlerGroup;
  private final HallServer hallServer;

  @Inject
  public GateAndRoomToHallDispatcherScript(
      GateAndRoomToHallHandlerGroup handlerGroup, HallServer hallServer) {
    this.handlerGroup = handlerGroup;
    this.hallServer = hallServer;
  }

  @Override
  public void tick(Channel channel, long now) {}

  @Override
  public void onChannelActive(Channel channel) {}

  @Override
  public void onChannelInactive(Channel channel) {
    RoomToHallUser roomToHallUser = channel.attr(RoomToHallUser.KEY).getAndRemove();
    if (roomToHallUser != null) {
      RoomToHallUser room = hallServer.getRooms().remove(roomToHallUser.getType(), roomToHallUser.getId());
    }
  }

  @Override
  public void onChannelRead(Channel channel, Message message) {
    IGateAndRoomToHallHandler handler = handlerGroup.handler(message.id());
    if (handler == null) {
      logger.error("handler is null:{}", message, new NullPointerException());
      return;
    }
    handler.exec(channel, message);
  }
}
