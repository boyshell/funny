package com.funny.blood.modules.hg;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class HallToDbHandlerGroup {
  public final ImmutableMap<Integer, com.funny.blood.modules.handler.HallToDbHandler> handlers;

  @Inject
  public HallToDbHandlerGroup(Injector injector) {
    ImmutableMap.Builder<Integer, com.funny.blood.modules.handler.HallToDbHandler> builder = ImmutableMap.builder();
    this.handlers = builder.build();
  }

  public com.funny.blood.modules.handler.HallToDbHandler handler(int id) {
    return handlers.get(id);
  }
}
