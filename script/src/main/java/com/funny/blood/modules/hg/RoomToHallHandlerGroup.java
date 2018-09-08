package com.funny.blood.modules.hg;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class RoomToHallHandlerGroup {
  public final ImmutableMap<Integer, com.funny.blood.modules.handler.RoomToHallHandler> handlers;

  @Inject
  public RoomToHallHandlerGroup(Injector injector) {
    ImmutableMap.Builder<Integer, com.funny.blood.modules.handler.RoomToHallHandler> builder = ImmutableMap.builder();
    builder.put(26, injector.getInstance(com.funny.blood.modules.base.room.RegisterRoomToHallRequestHandler.class));
    this.handlers = builder.build();
  }

  public com.funny.blood.modules.handler.RoomToHallHandler handler(int id) {
    return handlers.get(id);
  }
}
