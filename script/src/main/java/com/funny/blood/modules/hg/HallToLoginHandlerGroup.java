package com.funny.blood.modules.hg;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class HallToLoginHandlerGroup {
  public final ImmutableMap<Integer, com.funny.blood.modules.handler.HallToLoginHandler> handlers;

  @Inject
  public HallToLoginHandlerGroup(Injector injector) {
    ImmutableMap.Builder<Integer, com.funny.blood.modules.handler.HallToLoginHandler> builder = ImmutableMap.builder();
    this.handlers = builder.build();
  }

  public com.funny.blood.modules.handler.HallToLoginHandler handler(int id) {
    return handlers.get(id);
  }
}
