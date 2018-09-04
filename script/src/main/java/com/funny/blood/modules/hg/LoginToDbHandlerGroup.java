package com.funny.blood.modules.hg;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class LoginToDbHandlerGroup {
  public final ImmutableMap<Integer, com.funny.blood.modules.handler.LoginToDbHandler> handlers;

  @Inject
  public LoginToDbHandlerGroup(Injector injector) {
    ImmutableMap.Builder<Integer, com.funny.blood.modules.handler.LoginToDbHandler> builder = ImmutableMap.builder();
    this.handlers = builder.build();
  }

  public com.funny.blood.modules.handler.LoginToDbHandler handler(int id) {
    return handlers.get(id);
  }
}
