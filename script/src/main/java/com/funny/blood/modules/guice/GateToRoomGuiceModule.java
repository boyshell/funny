package com.funny.blood.modules.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class GateToRoomGuiceModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(com.funny.blood.modules.base.net.ForwardGateToRoomRequestHandler.class).in(Singleton.class);
  }
}
