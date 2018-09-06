package com.funny.blood.net.gate;

import com.funny.blood.net.AbstractDispatcher;
import com.funny.blood.net.IDispatcherScript;
import com.funny.blood.script.GateScript;
import com.google.inject.Inject;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import shell.lang.Governor;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@ChannelHandler.Sharable
public class ClientToGateDispatcher extends AbstractDispatcher {
  private final GateScript gateScript;

  private static final ThreadLocal<Set<Channel>> localChannels = new ThreadLocal<>();



  @Inject
  public ClientToGateDispatcher(GateScript gateScript) {
    super("client-to-gate-dispatcher", () -> new Governor(10, 1000));
    this.gateScript = gateScript;
  }

  @Override
  protected IDispatcherScript script() {
    return gateScript.client2gateDispatcher;
  }

  @Override
  protected ThreadLocal<Set<Channel>> localChannels() {
    return localChannels;
  }

}
