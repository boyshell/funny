package com.funny.blood.modules.hg;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class ClientToLoginHandlerGroup {
  public final ImmutableMap<Integer, com.funny.blood.modules.handler.ClientToLoginHandler> handlers;

  @Inject
  public ClientToLoginHandlerGroup(Injector injector) {
    ImmutableMap.Builder<Integer, com.funny.blood.modules.handler.ClientToLoginHandler> builder = ImmutableMap.builder();
    this.handlers = builder.build();
  }

  public com.funny.blood.modules.handler.ClientToLoginHandler handler(int id) {
    return handlers.get(id);
  }
}
