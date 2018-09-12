package com.funny.blood.server.login.net;

import com.funny.blood.net.AbstractDispatcher;
import com.funny.blood.net.IDispatcherScript;
import com.funny.blood.server.login.LoginScriptHolder;
import com.google.inject.Inject;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;

import java.util.Set;

@ChannelHandler.Sharable
public class GateToLoginDispatcher extends AbstractDispatcher {
  private final LoginScriptHolder script;

  private static final ThreadLocal<Set<Channel>> localChannels = new ThreadLocal<>();

  @Inject
  public GateToLoginDispatcher(LoginScriptHolder script) {
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
