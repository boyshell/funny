package com.funny.blood.modules.hg;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class HallToClientHandlerGroup {
  public final ImmutableMap<Integer, com.funny.blood.modules.handler.HallToClientHandler> handlers;

  @Inject
  public HallToClientHandlerGroup(Injector injector) {
    ImmutableMap.Builder<Integer, com.funny.blood.modules.handler.HallToClientHandler> builder = ImmutableMap.builder();
    builder.put(21, injector.getInstance(com.funny.blood.modules.base.login.UpdateValueRequestHandler.class));
    builder.put(28, injector.getInstance(com.funny.blood.modules.base.room.EnterRoomResponseHandler.class));
    builder.put(29, injector.getInstance(com.funny.blood.modules.base.room.EnterRoomErrorHandler.class));
    this.handlers = builder.build();
  }

  public com.funny.blood.modules.handler.HallToClientHandler handler(int id) {
    return handlers.get(id);
  }
}
