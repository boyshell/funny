package com.funny.blood.server.robot;

import com.funny.blood.ILauncher;
import com.funny.blood.GameGuiceModule;
import com.funny.blood.modules.hg.GateToClientHandlerGroup;
import com.funny.blood.modules.hg.HallToClientHandlerGroup;
import com.funny.blood.modules.hg.LoginToClientHandlerGroup;
import com.funny.blood.modules.hg.RoomToClientHandlerGroup;
import com.funny.blood.server.robot.net.RobotDispatcherScript;
import com.funny.blood.server.robot.net.RobotHandlerGroup;

public class RobotScriptGuiceModule extends GameGuiceModule {
  @Override
  protected void bind() {
    bindSingleton(ILauncher.class, RobotLauncher.class);

    bindSingleton(RobotDispatcherScript.class);
    bindSingleton(RobotHandlerGroup.class);
    bindSingleton(RoomToClientHandlerGroup.class);
    bindSingleton(GateToClientHandlerGroup.class);
    bindSingleton(HallToClientHandlerGroup.class);
    bindSingleton(LoginToClientHandlerGroup.class);
  }
}
