package com.funny.blood.modules.hg;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class GameToLoginHandlerGroup {
  public final ImmutableMap<Integer, com.funny.blood.modules.handler.GameToLoginHandler> handlers;

  @Inject
  public GameToLoginHandlerGroup(Injector injector) {
    ImmutableMap.Builder<Integer, com.funny.blood.modules.handler.GameToLoginHandler> builder = ImmutableMap.builder();
    this.handlers = builder.build();
  }

  public com.funny.blood.modules.handler.GameToLoginHandler handler(int id) {
    return handlers.get(id);
  }
}
