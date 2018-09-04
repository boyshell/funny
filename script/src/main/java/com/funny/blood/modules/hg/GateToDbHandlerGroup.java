package com.funny.blood.modules.hg;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class GateToDbHandlerGroup {
  public final ImmutableMap<Integer, com.funny.blood.modules.handler.GateToDbHandler> handlers;

  @Inject
  public GateToDbHandlerGroup(Injector injector) {
    ImmutableMap.Builder<Integer, com.funny.blood.modules.handler.GateToDbHandler> builder = ImmutableMap.builder();
    this.handlers = builder.build();
  }

  public com.funny.blood.modules.handler.GateToDbHandler handler(int id) {
    return handlers.get(id);
  }
}
