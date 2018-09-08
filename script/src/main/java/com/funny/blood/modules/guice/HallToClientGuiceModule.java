package com.funny.blood.modules.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class HallToClientGuiceModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(com.funny.blood.modules.base.hall.UpdateValueRequestHandler.class).in(Singleton.class);
  }
}
