package com.funny.blood.modules.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class GateToHallGuiceModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(com.funny.blood.modules.base.login.GetHallRequestHandler.class).in(Singleton.class);
    bind(com.funny.blood.modules.base.net.ForwardClientToHallRequestHandler.class).in(Singleton.class);
  }
}
