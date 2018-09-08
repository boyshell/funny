package com.funny.blood.modules.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class RoomToHallGuiceModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(com.funny.blood.modules.base.room.RegisterRoomToHallRequestHandler.class).in(Singleton.class);
  }
}
