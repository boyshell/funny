package com.funny.blood.modules.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class HallToGateGuiceModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(com.funny.blood.modules.base.hall.GetHallResponseHandler.class).in(Singleton.class);
    bind(com.funny.blood.modules.base.net.ForwardHallToClientRequestHandler.class).in(Singleton.class);
  }
}
