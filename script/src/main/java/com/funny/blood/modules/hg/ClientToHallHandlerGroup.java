package com.funny.blood.modules.hg;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class ClientToHallHandlerGroup {
  public final ImmutableMap<Integer, com.funny.blood.modules.handler.ClientToHallHandler> handlers;

  @Inject
  public ClientToHallHandlerGroup(Injector injector) {
    ImmutableMap.Builder<Integer, com.funny.blood.modules.handler.ClientToHallHandler> builder = ImmutableMap.builder();
    builder.put(27, injector.getInstance(com.funny.blood.modules.base.room.EnterRoomRequestHandler.class));
    this.handlers = builder.build();
  }

  public com.funny.blood.modules.handler.ClientToHallHandler handler(int id) {
    return handlers.get(id);
  }
}
