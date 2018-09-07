package com.funny.blood.modules.hg;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class RoomToLoginHandlerGroup {
  public final ImmutableMap<Integer, com.funny.blood.modules.handler.RoomToLoginHandler> handlers;

  @Inject
  public RoomToLoginHandlerGroup(Injector injector) {
    ImmutableMap.Builder<Integer, com.funny.blood.modules.handler.RoomToLoginHandler> builder = ImmutableMap.builder();
    this.handlers = builder.build();
  }

  public com.funny.blood.modules.handler.RoomToLoginHandler handler(int id) {
    return handlers.get(id);
  }
}
