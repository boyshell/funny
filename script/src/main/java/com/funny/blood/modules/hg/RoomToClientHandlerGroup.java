package com.funny.blood.modules.hg;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class RoomToClientHandlerGroup {
  public final ImmutableMap<Integer, com.funny.blood.modules.handler.RoomToClientHandler> handlers;

  @Inject
  public RoomToClientHandlerGroup(Injector injector) {
    ImmutableMap.Builder<Integer, com.funny.blood.modules.handler.RoomToClientHandler> builder = ImmutableMap.builder();
    builder.put(7, injector.getInstance(com.funny.blood.modules.poker.ddz.Test1RequestHandler.class));
    builder.put(18, injector.getInstance(com.funny.blood.modules.poker.zjh.ZJHDealRequestHandler.class));
    this.handlers = builder.build();
  }

  public com.funny.blood.modules.handler.RoomToClientHandler handler(int id) {
    return handlers.get(id);
  }
}
