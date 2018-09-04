package com.funny.blood.modules.hg;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class GameToDbHandlerGroup {
  public final ImmutableMap<Integer, com.funny.blood.modules.handler.GameToDbHandler> handlers;

  @Inject
  public GameToDbHandlerGroup(Injector injector) {
    ImmutableMap.Builder<Integer, com.funny.blood.modules.handler.GameToDbHandler> builder = ImmutableMap.builder();
    this.handlers = builder.build();
  }

  public com.funny.blood.modules.handler.GameToDbHandler handler(int id) {
    return handlers.get(id);
  }
}
