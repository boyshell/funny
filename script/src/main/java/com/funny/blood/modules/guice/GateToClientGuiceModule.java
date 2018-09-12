package com.funny.blood.modules.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class GateToClientGuiceModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(com.funny.blood.modules.base.login.LoginResponseHandler.class).in(Singleton.class);
    bind(com.funny.blood.modules.base.login.LoginErrorHandler.class).in(Singleton.class);
    bind(com.funny.blood.modules.base.login.VersionCheckResponseHandler.class).in(Singleton.class);
    bind(com.funny.blood.modules.base.login.VersionCheckErrorHandler.class).in(Singleton.class);
    bind(com.funny.blood.modules.base.net.KickRequestHandler.class).in(Singleton.class);
  }
}
