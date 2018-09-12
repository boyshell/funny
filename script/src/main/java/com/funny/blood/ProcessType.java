package com.funny.blood;

import com.funny.blood.modules.guice.*;
import com.funny.blood.server.gate.GateGuiceModule;
import com.funny.blood.server.gate.GateScriptGuiceModule;
import com.funny.blood.server.hall.HallGuiceModule;
import com.funny.blood.server.hall.HallScriptGuiceModule;
import com.funny.blood.server.login.LoginGuiceModule;
import com.funny.blood.server.login.LoginScriptGuiceModule;
import com.funny.blood.server.robot.RobotGuiceModule;
import com.funny.blood.server.robot.RobotScriptGuiceModule;
import com.funny.blood.server.room.RoomGuiceModule;
import com.funny.blood.server.room.RoomScriptGuiceModule;
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
