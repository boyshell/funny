package com.funny.blood.modules.hg;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class HallToRoomHandlerGroup {
  public final ImmutableMap<Integer, com.funny.blood.modules.handler.HallToRoomHandler> handlers;

  @Inject
  public HallToRoomHandlerGroup(Injector injector) {
    ImmutableMap.Builder<Integer, com.funny.blood.modules.handler.HallToRoomHandler> builder = ImmutableMap.builder();
    this.handlers = builder.build();
  }

  public com.funny.blood.modules.handler.HallToRoomHandler handler(int id) {
    return handlers.get(id);
  }
}
