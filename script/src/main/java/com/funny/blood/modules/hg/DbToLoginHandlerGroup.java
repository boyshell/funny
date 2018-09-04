package com.funny.blood.modules.hg;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class DbToLoginHandlerGroup {
  public final ImmutableMap<Integer, com.funny.blood.modules.handler.DbToLoginHandler> handlers;

  @Inject
  public DbToLoginHandlerGroup(Injector injector) {
    ImmutableMap.Builder<Integer, com.funny.blood.modules.handler.DbToLoginHandler> builder = ImmutableMap.builder();
    this.handlers = builder.build();
  }

  public com.funny.blood.modules.handler.DbToLoginHandler handler(int id) {
    return handlers.get(id);
  }
}
