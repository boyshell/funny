package com.funny.blood.server.robot.net;

import com.funny.blood.net.AbstractDispatcher;
import com.funny.blood.net.IDispatcherScript;
import com.funny.blood.server.robot.RobotScriptHolder;
import com.google.inject.Inject;
import io.netty.channel.Channel;

import java.util.Set;

public class RobotDispatcher extends AbstractDispatcher {
  private final RobotScriptHolder script;

  private static final ThreadLocal<Set<Channel>> localChannels = new ThreadLocal<>();

  @Inject
  public RobotDispatcher(RobotScriptHolder script) {
    super("robot", null);
    this.script = script;
  }

  @Override
  protected IDispatcherScript script() {
    return script.robotDispatcher;
  }

  @Override
  protected ThreadLocal<Set<Channel>> localChannels() {
    return localChannels;
  }

  @Override
  public void tick(long now) {
    super.tick(now);
  }
}
