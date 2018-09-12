package com.funny.blood.server.gate.net;

import com.funny.blood.net.AbstractDispatcher;
import com.funny.blood.net.IDispatcherScript;
import com.funny.blood.server.gate.GateScriptHolder;
import com.google.inject.Inject;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;

import java.util.Set;

@ChannelHandler.Sharable
public class HallToGateDispatcher extends AbstractDispatcher {

  private final GateScriptHolder script;

  private static final ThreadLocal<Set<Channel>> localChannels = new ThreadLocal<>();

  @Inject
  public HallToGateDispatcher(GateScriptHolder script) {
    super("hall-to-gate-dispatcher", null);
    this.script = script;
  }

  @Override
  protected IDispatcherScript script() {
    return script.hall2gateDispatcher;
  }

  @Override
  protected ThreadLocal<Set<Channel>> localChannels() {
    return localChannels;
  }
}
