package com.funny.blood;

import com.funny.blood.guice.*;
import com.funny.blood.modules.guice.*;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;

public enum ProcessType {
  ROBOT("robot") {
    @Override
    public Injector createInjector() {
      Injector injector = Guice.createInjector(Stage.PRODUCTION, new RobotGuiceModule());
      return injector.createChildInjector(
          new RobotScriptGuiceModule(),
          new GateToClientGuiceModule(),
          new LoginToClientGuiceModule(),
          new GameToClientGuiceModule(),
          new HallToClientGuiceModule());
    }
  },
  GATE("gate") {
    @Override
    public Injector createInjector() {
      Injector injector = Guice.createInjector(Stage.PRODUCTION, new GateGuiceModule());
      return injector.createChildInjector(
          new GateScriptGuiceModule(), new LoginToGateGuiceModule());
    }
  },
  LOGIN("login") {
    @Override
    public Injector createInjector() {
      Injector injector = Guice.createInjector(Stage.PRODUCTION, new LoginGuiceModule());
      return injector.createChildInjector(
          new LoginScriptGuiceModule(), new GateToLoginGuiceModule());
    }
  },
  GAME("game") {
    @Override
    public Injector createInjector() {
      Injector injector = Guice.createInjector(Stage.PRODUCTION);
      return injector.createChildInjector();
    }
  },
  HALL("hall") {
    @Override
    public Injector createInjector() {
      Injector injector = Guice.createInjector(Stage.PRODUCTION);
      return injector.createChildInjector();
    }
  },
  DB("db") {
    @Override
    public Injector createInjector() {
      Injector injector = Guice.createInjector(Stage.PRODUCTION);
      return injector.createChildInjector();
    }
  },
  ;
  public final String key;

  ProcessType(String key) {
    this.key = key;
  }

  public abstract Injector createInjector();
}
