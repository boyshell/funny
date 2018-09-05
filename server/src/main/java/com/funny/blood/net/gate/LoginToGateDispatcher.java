package com.funny.blood.net.gate;

import com.funny.blood.net.AbstractDispatcher;
import com.funny.blood.net.IDispatcherScript;
import com.funny.blood.script.GateScript;
import com.google.inject.Inject;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;

import java.util.Set;

@ChannelHandler.Sharable
public class LoginToGateDispatcher extends AbstractDispatcher {
  private final GateScript gateScript;

  private static final ThreadLocal<Set<Channel>> localChannels = new ThreadLocal<>();

  @Inject
  public LoginToGateDispatcher(GateScript gateScript) {
    super("login-to-gate-dispatcher", null);
    this.gateScript = gateScript;
  }

  @Override
  protected IDispatcherScript script() {
    return gateScript.login2gateDispatcher;
  }

  @Override
  protected ThreadLocal<Set<Channel>> localChannels() {
    return localChannels;
  }
}
