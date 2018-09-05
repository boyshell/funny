package com.funny.blood.modules.hg;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class LoginToClientHandlerGroup {
  public final ImmutableMap<Integer, com.funny.blood.modules.handler.LoginToClientHandler> handlers;

  @Inject
  public LoginToClientHandlerGroup(Injector injector) {
    ImmutableMap.Builder<Integer, com.funny.blood.modules.handler.LoginToClientHandler> builder = ImmutableMap.builder();
    this.handlers = builder.build();
  }

  public com.funny.blood.modules.handler.LoginToClientHandler handler(int id) {
    return handlers.get(id);
  }
}
