package com.funny.blood.modules.hg;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class DbToGateHandlerGroup {
  public final ImmutableMap<Integer, com.funny.blood.modules.handler.DbToGateHandler> handlers;

  @Inject
  public DbToGateHandlerGroup(Injector injector) {
    ImmutableMap.Builder<Integer, com.funny.blood.modules.handler.DbToGateHandler> builder = ImmutableMap.builder();
    this.handlers = builder.build();
  }

  public com.funny.blood.modules.handler.DbToGateHandler handler(int id) {
    return handlers.get(id);
  }
}
