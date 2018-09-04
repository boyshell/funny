package com.funny.blood.modules.hg;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class LoginToGameHandlerGroup {
  public final ImmutableMap<Integer, com.funny.blood.modules.handler.LoginToGameHandler> handlers;

  @Inject
  public LoginToGameHandlerGroup(Injector injector) {
    ImmutableMap.Builder<Integer, com.funny.blood.modules.handler.LoginToGameHandler> builder = ImmutableMap.builder();
    this.handlers = builder.build();
  }

  public com.funny.blood.modules.handler.LoginToGameHandler handler(int id) {
    return handlers.get(id);
  }
}
