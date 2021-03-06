package com.funny.blood.modules.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class GateToLoginGuiceModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(com.funny.blood.modules.base.login.GetUserIDRequestHandler.class).in(Singleton.class);
    bind(com.funny.blood.modules.base.net.RemoveClientUserInLoginRequestHandler.class).in(Singleton.class);
  }
}
