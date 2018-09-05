package com.funny.blood.modules.hg;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class GateToGameHandlerGroup {
  public final ImmutableMap<Integer, com.funny.blood.modules.handler.GateToGameHandler> handlers;

  @Inject
  public GateToGameHandlerGroup(Injector injector) {
    ImmutableMap.Builder<Integer, com.funny.blood.modules.handler.GateToGameHandler> builder = ImmutableMap.builder();
    builder.put(10, injector.getInstance(com.funny.blood.modules.base.net.ForwardGateToGameRequestHandler.class));
    this.handlers = builder.build();
  }

  public com.funny.blood.modules.handler.GateToGameHandler handler(int id) {
    return handlers.get(id);
  }
}
