package com.funny.blood.modules.hg;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class GameToClientHandlerGroup {
  public final ImmutableMap<Integer, com.funny.blood.modules.handler.GameToClientHandler> handlers;

  @Inject
  public GameToClientHandlerGroup(Injector injector) {
    ImmutableMap.Builder<Integer, com.funny.blood.modules.handler.GameToClientHandler> builder = ImmutableMap.builder();
    builder.put(7, injector.getInstance(com.funny.blood.modules.poker.ddz.Test1RequestHandler.class));
    builder.put(8, injector.getInstance(com.funny.blood.modules.poker.zjh.Test2RequestHandler.class));
    this.handlers = builder.build();
  }

  public com.funny.blood.modules.handler.GameToClientHandler handler(int id) {
    return handlers.get(id);
  }
}
