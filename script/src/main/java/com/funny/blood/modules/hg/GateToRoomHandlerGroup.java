package com.funny.blood.modules.hg;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class GateToRoomHandlerGroup {
  public final ImmutableMap<Integer, com.funny.blood.modules.handler.GateToRoomHandler> handlers;

  @Inject
  public GateToRoomHandlerGroup(Injector injector) {
    ImmutableMap.Builder<Integer, com.funny.blood.modules.handler.GateToRoomHandler> builder = ImmutableMap.builder();
    builder.put(10, injector.getInstance(com.funny.blood.modules.base.net.ForwardGateToRoomRequestHandler.class));
    this.handlers = builder.build();
  }

  public com.funny.blood.modules.handler.GateToRoomHandler handler(int id) {
    return handlers.get(id);
  }
}
