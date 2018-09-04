package com.funny.blood.modules.hg;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class ClientToGameHandlerGroup {
  public final ImmutableMap<Integer, com.funny.blood.modules.handler.ClientToGameHandler> handlers;

  @Inject
  public ClientToGameHandlerGroup(Injector injector) {
    ImmutableMap.Builder<Integer, com.funny.blood.modules.handler.ClientToGameHandler> builder = ImmutableMap.builder();
    this.handlers = builder.build();
  }

  public com.funny.blood.modules.handler.ClientToGameHandler handler(int id) {
    return handlers.get(id);
  }
}
