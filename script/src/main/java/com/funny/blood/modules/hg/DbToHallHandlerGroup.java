package com.funny.blood.modules.hg;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class DbToHallHandlerGroup {
  public final ImmutableMap<Integer, com.funny.blood.modules.handler.DbToHallHandler> handlers;

  @Inject
  public DbToHallHandlerGroup(Injector injector) {
    ImmutableMap.Builder<Integer, com.funny.blood.modules.handler.DbToHallHandler> builder = ImmutableMap.builder();
    this.handlers = builder.build();
  }

  public com.funny.blood.modules.handler.DbToHallHandler handler(int id) {
    return handlers.get(id);
  }
}
