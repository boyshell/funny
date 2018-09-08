package com.funny.blood.net.gate;

import com.funny.blood.modules.handler.HallToGateHandler;
import com.funny.blood.modules.hg.HallToGateHandlerGroup;
import com.funny.blood.net.IDispatcherScript;
import com.google.inject.Inject;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shell.net.Message;

public class HallToGateDispatcherScript implements IDispatcherScript {
  private static final Logger logger = LoggerFactory.getLogger(HallToGateDispatcherScript.class);
  private final HallToGateHandlerGroup handlerGroup;

  @Inject
  public HallToGateDispatcherScript(HallToGateHandlerGroup handlerGroup) {
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
    HallToGateHandler handler = handlerGroup.handler(message.id());
    if (handler == null) {
      logger.error("handler is null:{}", message);
      return;
    }
    handler.exec(channel, message);
  }
}
