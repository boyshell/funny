package com.funny.blood.modules.hg;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class GameToGateHandlerGroup {
  public final ImmutableMap<Integer, com.funny.blood.modules.handler.GameToGateHandler> handlers;

  @Inject
  public GameToGateHandlerGroup(Injector injector) {
    ImmutableMap.Builder<Integer, com.funny.blood.modules.handler.GameToGateHandler> builder = ImmutableMap.builder();
    this.handlers = builder.build();
  }

  public com.funny.blood.modules.handler.GameToGateHandler handler(int id) {
    return handlers.get(id);
  }
}