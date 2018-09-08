package com.funny.blood.modules.hg;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class LoginToGateHandlerGroup {
  public final ImmutableMap<Integer, com.funny.blood.modules.handler.LoginToGateHandler> handlers;

  @Inject
  public LoginToGateHandlerGroup(Injector injector) {
    ImmutableMap.Builder<Integer, com.funny.blood.modules.handler.LoginToGateHandler> builder = ImmutableMap.builder();
    builder.put(17, injector.getInstance(com.funny.blood.modules.base.verify.GetUserIDResponseHandler.class));
    this.handlers = builder.build();
  }

  public com.funny.blood.modules.handler.LoginToGateHandler handler(int id) {
    return handlers.get(id);
  }
}
