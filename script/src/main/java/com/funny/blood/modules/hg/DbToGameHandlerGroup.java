package com.funny.blood.modules.hg;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class DbToGameHandlerGroup {
  public final ImmutableMap<Integer, com.funny.blood.modules.handler.DbToGameHandler> handlers;

  @Inject
  public DbToGameHandlerGroup(Injector injector) {
    ImmutableMap.Builder<Integer, com.funny.blood.modules.handler.DbToGameHandler> builder = ImmutableMap.builder();
    this.handlers = builder.build();
  }

  public com.funny.blood.modules.handler.DbToGameHandler handler(int id) {
    return handlers.get(id);
  }
}
