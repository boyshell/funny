package com.funny.blood.server.hall.net;

import com.funny.blood.net.AbstractDispatcher;
import com.funny.blood.net.IDispatcherScript;
import com.funny.blood.server.hall.HallScriptHolder;
import com.google.inject.Inject;
import io.netty.channel.Channel;

import java.util.Set;

public class HallDispatcher extends AbstractDispatcher {
  private final HallScriptHolder script;

  private static final ThreadLocal<Set<Channel>> localChannels = new ThreadLocal<>();

  @Inject
  public HallDispatcher(HallScriptHolder script) {
    super("hall-dispatcher", null);
    this.script = script;
  }

  @Override
  protected IDispatcherScript script() {
    return script.gateAndRoom2hallDispatcher;
  }

  @Override
  protected ThreadLocal<Set<Channel>> localChannels() {
    return localChannels;
  }
}
