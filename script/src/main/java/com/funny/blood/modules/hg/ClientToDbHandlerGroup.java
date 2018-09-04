package com.funny.blood.modules.hg;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class ClientToDbHandlerGroup {
  public final ImmutableMap<Integer, com.funny.blood.modules.handler.ClientToDbHandler> handlers;

  @Inject
  public ClientToDbHandlerGroup(Injector injector) {
    ImmutableMap.Builder<Integer, com.funny.blood.modules.handler.ClientToDbHandler> builder = ImmutableMap.builder();
    this.handlers = builder.build();
  }

  public com.funny.blood.modules.handler.ClientToDbHandler handler(int id) {
    return handlers.get(id);
  }
}
