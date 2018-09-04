package com.funny.blood.modules.hg;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class GateToLoginHandlerGroup {
  public final ImmutableMap<Integer, com.funny.blood.modules.handler.GateToLoginHandler> handlers;

  @Inject
  public GateToLoginHandlerGroup(Injector injector) {
    ImmutableMap.Builder<Integer, com.funny.blood.modules.handler.GateToLoginHandler> builder = ImmutableMap.builder();
    this.handlers = builder.build();
  }

  public com.funny.blood.modules.handler.GateToLoginHandler handler(int id) {
    return handlers.get(id);
  }
}
