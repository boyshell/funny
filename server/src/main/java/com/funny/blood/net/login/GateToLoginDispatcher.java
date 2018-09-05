package com.funny.blood.net.login;

import com.funny.blood.net.AbstractDispatcher;
import com.funny.blood.net.IDispatcherScript;
import com.funny.blood.script.LoginScript;
import com.google.inject.Inject;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;

import java.util.Set;

@ChannelHandler.Sharable
public class GateToLoginDispatcher extends AbstractDispatcher {
  private final LoginScript script;

  private static final ThreadLocal<Set<Channel>> localChannels = new ThreadLocal<>();

  @Inject
  public GateToLoginDispatcher(LoginScript script) {
    super("gate-to-login-dispatcher", null);
    this.script = script;
  }

  @Override
  protected IDispatcherScript script() {
    return script.gate2loginDispatcher;
  }

  @Override
  protected ThreadLocal<Set<Channel>> localChannels() {
    return localChannels;
  }
}
