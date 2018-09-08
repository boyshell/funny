package com.funny.blood.net.hall;

import com.funny.blood.net.AbstractDispatcher;
import com.funny.blood.net.IDispatcherScript;
import com.funny.blood.script.HallScript;
import com.google.inject.Inject;
import io.netty.channel.Channel;

import java.util.Set;

public class HallDispatcher extends AbstractDispatcher {
  private final HallScript script;

  private static final ThreadLocal<Set<Channel>> localChannels = new ThreadLocal<>();

  @Inject
  public HallDispatcher(HallScript script) {
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
