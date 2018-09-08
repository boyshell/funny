package com.funny.blood;

import com.funny.blood.guice.*;
import com.funny.blood.modules.guice.*;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;

public enum ProcessType {
  ROBOT {
    @Override
    public Injector createInjector() {
      Injector injector = Guice.createInjector(Stage.PRODUCTION, new RobotGuiceModule());
      return injector.createChildInjector(
          new RobotScriptGuiceModule(),
          new GateToClientGuiceModule(),
          new LoginToClientGuiceModule(),
          new RoomToClientGuiceModule(),
          new HallToClientGuiceModule());
    }
  },
  GATE {
    @Override
    public Injector createInjector() {
      Injector injector = Guice.createInjector(Stage.PRODUCTION, new GateGuiceModule());
      return injector.createChildInjector(
          new GateScriptGuiceModule(),
          new LoginToGateGuiceModule(),
          new HallToGateGuiceModule(),
          new RoomToGateGuiceModule());
    }
  },
  LOGIN {
    @Override
    public Injector createInjector() {
      Injector injector = Guice.createInjector(Stage.PRODUCTION, new LoginGuiceModule());
      return injector.createChildInjector(
          new LoginScriptGuiceModule(), new GateToLoginGuiceModule());
    }
  },
  ROOM {
    @Override
    public Injector createInjector() {
      Injector injector = Guice.createInjector(Stage.PRODUCTION, new RoomGuiceModule());
      return injector.createChildInjector(new RoomScriptGuiceModule(), new GateToRoomGuiceModule());
    }
  },
  HALL {
    @Override
    public Injector createInjector() {
      Injector injector = Guice.createInjector(Stage.PRODUCTION, new HallGuiceModule());
      return injector.createChildInjector(
          new HallScriptGuiceModule(),
          new GateToHallGuiceModule(),
          new ClientToHallGuiceModule(),
          new RoomToHallGuiceModule());
    }
  },
  DB {
    @Override
    public Injector createInjector() {
      Injector injector = Guice.createInjector(Stage.PRODUCTION);
      return injector.createChildInjector();
    }
  },
  ;

  public abstract Injector createInjector();
}
