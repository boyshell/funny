package com.funny.blood.net.hall;

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

  @Inject
  public GateAndRoomToHallDispatcherScript(GateAndRoomToHallHandlerGroup handlerGroup) {
    this.handlerGroup = handlerGroup;
  }

  @Override
  public void tick(Channel channel, long now) {}

  @Override
  public void onChannelActive(Channel channel) {}

  @Override
  public void onChannelInactive(Channel channel) {}

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
