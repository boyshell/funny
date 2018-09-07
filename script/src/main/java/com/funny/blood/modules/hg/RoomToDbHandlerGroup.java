package com.funny.blood.modules.hg;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class RoomToDbHandlerGroup {
  public final ImmutableMap<Integer, com.funny.blood.modules.handler.RoomToDbHandler> handlers;

  @Inject
  public RoomToDbHandlerGroup(Injector injector) {
    ImmutableMap.Builder<Integer, com.funny.blood.modules.handler.RoomToDbHandler> builder = ImmutableMap.builder();
    this.handlers = builder.build();
  }

  public com.funny.blood.modules.handler.RoomToDbHandler handler(int id) {
    return handlers.get(id);
  }
}
