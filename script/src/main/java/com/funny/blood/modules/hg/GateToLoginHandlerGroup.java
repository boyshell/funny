package com.funny.blood.modules.hg;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class GateToLoginHandlerGroup {
  public final ImmutableMap<Integer, com.funny.blood.modules.handler.GateToLoginHandler> handlers;

  @Inject
  public GateToLoginHandlerGroup(Injector injector) {
    ImmutableMap.Builder<Integer, com.funny.blood.modules.handler.GateToLoginHandler> builder = ImmutableMap.builder();
    builder.put(12, injector.getInstance(com.funny.blood.modules.base.net.ForwardGateToLoginRequestHandler.class));
    builder.put(16, injector.getInstance(com.funny.blood.modules.base.net.RemoveClientUserInLoginRequestHandler.class));
    builder.put(13, injector.getInstance(com.funny.blood.modules.base.verify.Login0RequestHandler.class));
    this.handlers = builder.build();
  }

  public com.funny.blood.modules.handler.GateToLoginHandler handler(int id) {
    return handlers.get(id);
  }
}
