package com.funny.blood.modules.hg;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class DbToRoomHandlerGroup {
  public final ImmutableMap<Integer, com.funny.blood.modules.handler.DbToRoomHandler> handlers;

  @Inject
  public DbToRoomHandlerGroup(Injector injector) {
    ImmutableMap.Builder<Integer, com.funny.blood.modules.handler.DbToRoomHandler> builder = ImmutableMap.builder();
    this.handlers = builder.build();
  }

  public com.funny.blood.modules.handler.DbToRoomHandler handler(int id) {
    return handlers.get(id);
  }
}
