package com.funny.blood.modules.hg;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class ClientToGateHandlerGroup {
  public final ImmutableMap<Integer, com.funny.blood.modules.handler.ClientToGateHandler> handlers;

  @Inject
  public ClientToGateHandlerGroup(Injector injector) {
    ImmutableMap.Builder<Integer, com.funny.blood.modules.handler.ClientToGateHandler> builder = ImmutableMap.builder();
    this.handlers = builder.build();
  }

  public com.funny.blood.modules.handler.ClientToGateHandler handler(int id) {
    return handlers.get(id);
  }
}
