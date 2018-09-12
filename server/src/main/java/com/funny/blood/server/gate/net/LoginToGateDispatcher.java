package com.funny.blood.server.gate.net;

import com.funny.blood.net.AbstractDispatcher;
import com.funny.blood.net.IDispatcherScript;
import com.funny.blood.server.gate.GateScriptHolder;
import com.google.inject.Inject;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;

import java.util.Set;

@ChannelHandler.Sharable
public class LoginToGateDispatcher extends AbstractDispatcher {
  private final GateScriptHolder gateScriptHolder;

  private static final ThreadLocal<Set<Channel>> localChannels = new ThreadLocal<>();

  @Inject
  public LoginToGateDispatcher(GateScriptHolder gateScriptHolder) {
    super("login-to-gate-dispatcher", null);
    this.gateScriptHolder = gateScriptHolder;
  }

  @Override
  protected IDispatcherScript script() {
    return gateScriptHolder.login2gateDispatcher;
  }

  @Override
  protected ThreadLocal<Set<Channel>> localChannels() {
    return localChannels;
  }
}
