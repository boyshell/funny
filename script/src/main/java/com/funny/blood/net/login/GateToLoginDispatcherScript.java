package com.funny.blood.net.login;

import com.funny.blood.modules.handler.GateToLoginHandler;
import com.funny.blood.modules.hg.GateToLoginHandlerGroup;
import com.funny.blood.net.IDispatcherScript;
import com.google.inject.Inject;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shell.net.Message;

public class GateToLoginDispatcherScript implements IDispatcherScript {
  private static final Logger logger = LoggerFactory.getLogger(GateToLoginDispatcherScript.class);

  private final GateToLoginHandlerGroup handlerGroup;

  @Inject
  public GateToLoginDispatcherScript(GateToLoginHandlerGroup handlerGroup) {
    this.handlerGroup = handlerGroup;
  }

  @Override
  public void tick(Channel channel, long now) {
    // todo
  }

  @Override
  public void onChannelActive(Channel channel) {
    channel.attr(GateToLoginUser.KEY).set(new GateToLoginUser(channel, Thread.currentThread()));
  }

  @Override
  public void onChannelInactive(Channel channel) {
    channel.attr(GateToLoginUser.KEY).remove();
    // todo
  }

  @Override
  public void onChannelRead(Channel channel, Message message) {
    GateToLoginUser netUser = channel.attr(GateToLoginUser.KEY).get();
    if (netUser == null) {
      logger.error("net user is null:{}", message.getClass().getSimpleName());
      return;
    }
    GateToLoginHandler handler = handlerGroup.handler(message.id());
    if (handler == null) {
      logger.error("handler is null:{}", message.getClass().getSimpleName());
      return;
    }
    handler.exec(netUser, message);
  }
}
