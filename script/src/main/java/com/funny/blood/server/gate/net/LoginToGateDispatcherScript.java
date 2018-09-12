package com.funny.blood.server.gate.net;

import com.funny.blood.modules.handler.LoginToGateHandler;
import com.funny.blood.modules.hg.LoginToGateHandlerGroup;
import com.funny.blood.net.IDispatcherScript;
import com.google.inject.Inject;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shell.net.Message;

public class LoginToGateDispatcherScript implements IDispatcherScript {
  private static final Logger logger = LoggerFactory.getLogger(LoginToGateDispatcherScript.class);
  private final LoginToGateHandlerGroup handlerGroup;

  @Inject
  public LoginToGateDispatcherScript(LoginToGateHandlerGroup handlerGroup) {
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
    LoginToGateHandler handler = handlerGroup.handler(message.id());
    if (handler == null) {
      logger.error("handler is null:{}", message);
      return;
    }
    handler.exec(channel, message);
  }
}
