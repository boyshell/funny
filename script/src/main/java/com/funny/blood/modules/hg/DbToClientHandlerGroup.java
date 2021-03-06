package com.funny.blood.modules.hg;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class DbToClientHandlerGroup {
  public final ImmutableMap<Integer, com.funny.blood.modules.handler.DbToClientHandler> handlers;

  @Inject
  public DbToClientHandlerGroup(Injector injector) {
    ImmutableMap.Builder<Integer, com.funny.blood.modules.handler.DbToClientHandler> builder = ImmutableMap.builder();
    this.handlers = builder.build();
  }

  public com.funny.blood.modules.handler.DbToClientHandler handler(int id) {
    return handlers.get(id);
  }
}
