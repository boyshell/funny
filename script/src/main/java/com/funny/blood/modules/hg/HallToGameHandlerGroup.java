package com.funny.blood.modules.hg;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class HallToGameHandlerGroup {
  public final ImmutableMap<Integer, com.funny.blood.modules.handler.HallToGameHandler> handlers;

  @Inject
  public HallToGameHandlerGroup(Injector injector) {
    ImmutableMap.Builder<Integer, com.funny.blood.modules.handler.HallToGameHandler> builder = ImmutableMap.builder();
    this.handlers = builder.build();
  }

  public com.funny.blood.modules.handler.HallToGameHandler handler(int id) {
    return handlers.get(id);
  }
}
