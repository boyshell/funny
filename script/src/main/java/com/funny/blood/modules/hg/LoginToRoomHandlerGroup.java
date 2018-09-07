package com.funny.blood.modules.hg;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class LoginToRoomHandlerGroup {
  public final ImmutableMap<Integer, com.funny.blood.modules.handler.LoginToRoomHandler> handlers;

  @Inject
  public LoginToRoomHandlerGroup(Injector injector) {
    ImmutableMap.Builder<Integer, com.funny.blood.modules.handler.LoginToRoomHandler> builder = ImmutableMap.builder();
    this.handlers = builder.build();
  }

  public com.funny.blood.modules.handler.LoginToRoomHandler handler(int id) {
    return handlers.get(id);
  }
}
