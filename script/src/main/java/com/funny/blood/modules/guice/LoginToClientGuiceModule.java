package com.funny.blood.modules.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class LoginToClientGuiceModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(com.funny.blood.modules.base.verify.LoginResponseHandler.class).in(Singleton.class);
    bind(com.funny.blood.modules.base.verify.LoginErrorHandler.class).in(Singleton.class);
  }
}
