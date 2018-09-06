package com.funny.blood.modules.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class GameToClientGuiceModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(com.funny.blood.modules.poker.ddz.Test1RequestHandler.class).in(Singleton.class);
    bind(com.funny.blood.modules.poker.zjh.ZJHDealRequestHandler.class).in(Singleton.class);
  }
}
