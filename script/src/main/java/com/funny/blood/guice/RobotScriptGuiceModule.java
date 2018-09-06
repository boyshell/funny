package com.funny.blood.guice;

import com.funny.blood.GameGuiceModule;
import com.funny.blood.ILauncher;
import com.funny.blood.launcher.RobotLauncher;
import com.funny.blood.modules.hg.GameToClientHandlerGroup;
import com.funny.blood.modules.hg.GateToClientHandlerGroup;
import com.funny.blood.modules.hg.HallToClientHandlerGroup;
import com.funny.blood.modules.hg.LoginToClientHandlerGroup;
import com.funny.blood.net.robot.RobotDispatcherScript;
import com.funny.blood.net.robot.RobotHandlerGroup;

public class RobotScriptGuiceModule extends GameGuiceModule {
  @Override
  protected void bind() {
    bindSingleton(ILauncher.class, RobotLauncher.class);

    bindSingleton(RobotDispatcherScript.class);
    bindSingleton(RobotHandlerGroup.class);
    bindSingleton(GameToClientHandlerGroup.class);
    bindSingleton(GateToClientHandlerGroup.class);
    bindSingleton(HallToClientHandlerGroup.class);
    bindSingleton(LoginToClientHandlerGroup.class);
  }
}
