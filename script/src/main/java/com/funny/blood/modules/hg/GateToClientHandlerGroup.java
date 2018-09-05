package com.funny.blood.modules.hg;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class GateToClientHandlerGroup {
  public final ImmutableMap<Integer, com.funny.blood.modules.handler.GateToClientHandler> handlers;

  @Inject
  public GateToClientHandlerGroup(Injector injector) {
    ImmutableMap.Builder<Integer, com.funny.blood.modules.handler.GateToClientHandler> builder = ImmutableMap.builder();
    builder.put(9, injector.getInstance(com.funny.blood.modules.base.net.KickRequestHandler.class));
    builder.put(2, injector.getInstance(com.funny.blood.modules.base.verify.LoginResponseHandler.class));
    builder.put(3, injector.getInstance(com.funny.blood.modules.base.verify.LoginErrorHandler.class));
    builder.put(5, injector.getInstance(com.funny.blood.modules.base.verify.VersionCheckResponseHandler.class));
    builder.put(6, injector.getInstance(com.funny.blood.modules.base.verify.VersionCheckErrorHandler.class));
    this.handlers = builder.build();
  }

  public com.funny.blood.modules.handler.GateToClientHandler handler(int id) {
    return handlers.get(id);
  }
}
