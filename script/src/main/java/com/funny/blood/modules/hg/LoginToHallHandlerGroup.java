package com.funny.blood.modules.hg;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class LoginToHallHandlerGroup {
  public final ImmutableMap<Integer, com.funny.blood.modules.handler.LoginToHallHandler> handlers;

  @Inject
  public LoginToHallHandlerGroup(Injector injector) {
    ImmutableMap.Builder<Integer, com.funny.blood.modules.handler.LoginToHallHandler> builder = ImmutableMap.builder();
    this.handlers = builder.build();
  }

  public com.funny.blood.modules.handler.LoginToHallHandler handler(int id) {
    return handlers.get(id);
  }
}
