package com.funny.blood.net;

import io.netty.channel.Channel;
import shell.lang.Governor;
import shell.misc.Factory;
import shell.net.Message;
import shell.net.MessageHandler;

import javax.annotation.Nullable;

public abstract class AbstractDispatcher extends MessageHandler {
  public AbstractDispatcher(String name, @Nullable Factory<Governor> governorFactory) {
    super(name, governorFactory);
  }

  @Override
  protected void tick(Channel channel, long now) {
    IDispatcherScript script = script();
    if (script != null) {
      script.tick(channel, now);
    }
  }

  @Override
  protected void onChannelActive(Channel channel) {
    IDispatcherScript script = script();
    if (script != null) {
      script.onChannelActive(channel);
    }
  }

  @Override
  protected void onChannelInactive(Channel channel) {
    IDispatcherScript script = script();
    if (script != null) {
      script.onChannelInactive(channel);
    }
  }

  @Override
  protected void onChannelRead(Channel channel, Message message) {
    IDispatcherScript script = script();
    if (script != null) {
      script.onChannelRead(channel, message);
    }
  }

  protected abstract IDispatcherScript script();
}
