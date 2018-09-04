package com.funny.blood.modules.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class GateToClientGuiceModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(com.funny.blood.modules.base.verify.VersionCheckResponseHandler.class).in(Singleton.class);
    bind(com.funny.blood.modules.base.verify.VersionCheckErrorHandler.class).in(Singleton.class);
  }
}
