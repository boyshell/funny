package com.funny.blood.modules.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class GateToLoginGuiceModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(com.funny.blood.modules.base.net.ForwardGateToLoginRequestHandler.class).in(Singleton.class);
    bind(com.funny.blood.modules.base.net.RemoveClientUserInLoginRequestHandler.class).in(Singleton.class);
    bind(com.funny.blood.modules.base.verify.Login0RequestHandler.class).in(Singleton.class);
  }
}
