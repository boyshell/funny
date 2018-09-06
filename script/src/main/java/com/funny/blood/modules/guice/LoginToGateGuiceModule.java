package com.funny.blood.modules.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class LoginToGateGuiceModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(com.funny.blood.modules.base.net.ForwardLoginToGateRequestHandler.class).in(Singleton.class);
    bind(com.funny.blood.modules.base.verify.LockUserRequestHandler.class).in(Singleton.class);
  }
}
