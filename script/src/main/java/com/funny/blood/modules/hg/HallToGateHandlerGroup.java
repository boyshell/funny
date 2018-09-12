package com.funny.blood.modules.hg;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class HallToGateHandlerGroup {
  public final ImmutableMap<Integer, com.funny.blood.modules.handler.HallToGateHandler> handlers;

  @Inject
  public HallToGateHandlerGroup(Injector injector) {
    ImmutableMap.Builder<Integer, com.funny.blood.modules.handler.HallToGateHandler> builder = ImmutableMap.builder();
    builder.put(24, injector.getInstance(com.funny.blood.modules.base.login.GetHallResponseHandler.class));
    builder.put(22, injector.getInstance(com.funny.blood.modules.base.net.ForwardHallToClientRequestHandler.class));
    builder.put(33, injector.getInstance(com.funny.blood.modules.base.room.AddRoomRequestHandler.class));
    builder.put(36, injector.getInstance(com.funny.blood.modules.base.room.BindRoomRequestHandler.class));
    builder.put(34, injector.getInstance(com.funny.blood.modules.base.room.InitRoomRequestHandler.class));
    builder.put(35, injector.getInstance(com.funny.blood.modules.base.room.RemoveRoomRequestHandler.class));
    this.handlers = builder.build();
  }

  public com.funny.blood.modules.handler.HallToGateHandler handler(int id) {
    return handlers.get(id);
  }
}
