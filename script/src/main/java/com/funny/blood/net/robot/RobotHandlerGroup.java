package com.funny.blood.net.robot;

import com.funny.blood.modules.hg.GameToClientHandlerGroup;
import com.funny.blood.modules.hg.GateToClientHandlerGroup;
import com.funny.blood.modules.hg.HallToClientHandlerGroup;
import com.funny.blood.modules.hg.LoginToClientHandlerGroup;
import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;

import java.util.HashMap;
import java.util.Map;

public class RobotHandlerGroup {
  public final ImmutableMap<Integer, IRobotHandler> handlers;

  @Inject
  public RobotHandlerGroup(
      GateToClientHandlerGroup gateToClientHandlerGroup,
      LoginToClientHandlerGroup loginToClientHandlerGroup,
      GameToClientHandlerGroup gameToClientHandlerGroup,
      HallToClientHandlerGroup hallToClientHandlerGroup) {
    Map<Integer, IRobotHandler> map = new HashMap<>();
    map.putAll(gateToClientHandlerGroup.handlers);
    map.putAll(loginToClientHandlerGroup.handlers);
    map.putAll(gameToClientHandlerGroup.handlers);
    map.putAll(hallToClientHandlerGroup.handlers);

    handlers = ImmutableMap.copyOf(map);
  }

  public IRobotHandler handler(int id) {
    return handlers.get(id);
  }
}