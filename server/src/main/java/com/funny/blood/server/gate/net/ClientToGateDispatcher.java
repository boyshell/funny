package com.funny.blood.server.gate.net;

import com.funny.blood.net.AbstractDispatcher;
import com.funny.blood.net.IDispatcherScript;
import com.funny.blood.server.gate.GateScriptHolder;
import com.google.inject.Inject;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import shell.lang.Governor;

import java.util.Set;

@ChannelHandler.Sharable
public class ClientToGateDispatcher extends AbstractDispatcher {
  private final GateScriptHolder gateScriptHolder;

  private static final ThreadLocal<Set<Channel>> localChannels = new ThreadLocal<>();



  @Inject
  public ClientToGateDispatcher(GateScriptHolder gateScriptHolder) {
    super("client-to-gate-dispatcher", () -> new Governor(10, 1000));
    this.gateScriptHolder = gateScriptHolder;
  }

  @Override
  protected IDispatcherScript script() {
    return gateScriptHolder.client2gateDispatcher;
  }

  @Override
  protected ThreadLocal<Set<Channel>> localChannels() {
    return localChannels;
  }

}
