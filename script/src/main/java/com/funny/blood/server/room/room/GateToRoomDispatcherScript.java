package com.funny.blood.server.room.room;

import com.funny.blood.modules.handler.GateToRoomHandler;
import com.funny.blood.modules.hg.GateToRoomHandlerGroup;
import com.funny.blood.net.IDispatcherScript;
import com.google.inject.Inject;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shell.net.Message;

public class GateToRoomDispatcherScript implements IDispatcherScript {
  private static final Logger logger = LoggerFactory.getLogger(GateToRoomDispatcherScript.class);
  private final GateToRoomHandlerGroup handlerGroup;

  @Inject
  public GateToRoomDispatcherScript(GateToRoomHandlerGroup handlerGroup) {
    this.handlerGroup = handlerGroup;
  }

  @Override
  public void tick(Channel channel, long now) {
    // todo
  }

  @Override
  public void onChannelActive(Channel channel) {
    // todo
  }

  @Override
  public void onChannelInactive(Channel channel) {
    // todo
  }

  @Override
  public void onChannelRead(Channel channel, Message message) {
    GateToRoomHandler handler = handlerGroup.handler(message.id());
    if (handler == null) {
      logger.error("handler is null:{}", message, new NullPointerException());
      return;
    }
    handler.exec(channel, message);
  }
}
