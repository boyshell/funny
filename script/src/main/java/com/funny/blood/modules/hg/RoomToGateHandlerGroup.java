package com.funny.blood.modules.hg;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class RoomToGateHandlerGroup {
  public final ImmutableMap<Integer, com.funny.blood.modules.handler.RoomToGateHandler> handlers;

  @Inject
  public RoomToGateHandlerGroup(Injector injector) {
    ImmutableMap.Builder<Integer, com.funny.blood.modules.handler.RoomToGateHandler> builder = ImmutableMap.builder();
    this.handlers = builder.build();
  }

  public com.funny.blood.modules.handler.RoomToGateHandler handler(int id) {
    return handlers.get(id);
  }
}
