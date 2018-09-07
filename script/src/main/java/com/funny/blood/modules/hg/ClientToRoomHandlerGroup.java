package com.funny.blood.modules.hg;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class ClientToRoomHandlerGroup {
  public final ImmutableMap<Integer, com.funny.blood.modules.handler.ClientToRoomHandler> handlers;

  @Inject
  public ClientToRoomHandlerGroup(Injector injector) {
    ImmutableMap.Builder<Integer, com.funny.blood.modules.handler.ClientToRoomHandler> builder = ImmutableMap.builder();
    this.handlers = builder.build();
  }

  public com.funny.blood.modules.handler.ClientToRoomHandler handler(int id) {
    return handlers.get(id);
  }
}
