package com.funny.blood.modules.hg;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class GameToHallHandlerGroup {
  public final ImmutableMap<Integer, com.funny.blood.modules.handler.GameToHallHandler> handlers;

  @Inject
  public GameToHallHandlerGroup(Injector injector) {
    ImmutableMap.Builder<Integer, com.funny.blood.modules.handler.GameToHallHandler> builder = ImmutableMap.builder();
    this.handlers = builder.build();
  }

  public com.funny.blood.modules.handler.GameToHallHandler handler(int id) {
    return handlers.get(id);
  }
}
