package com.funny.blood.modules.hg;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class GateToHallHandlerGroup {
  public final ImmutableMap<Integer, com.funny.blood.modules.handler.GateToHallHandler> handlers;

  @Inject
  public GateToHallHandlerGroup(Injector injector) {
    ImmutableMap.Builder<Integer, com.funny.blood.modules.handler.GateToHallHandler> builder = ImmutableMap.builder();
    builder.put(23, injector.getInstance(com.funny.blood.modules.base.hall.GetHallRequestHandler.class));
    builder.put(11, injector.getInstance(com.funny.blood.modules.base.net.ForwardClientToHallRequestHandler.class));
    this.handlers = builder.build();
  }

  public com.funny.blood.modules.handler.GateToHallHandler handler(int id) {
    return handlers.get(id);
  }
}
