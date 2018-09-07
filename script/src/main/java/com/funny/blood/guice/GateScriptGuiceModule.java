package com.funny.blood.guice;

import com.funny.blood.RoomGuiceModule;
import com.funny.blood.ILauncher;
import com.funny.blood.launcher.GateLauncher;
import com.funny.blood.modules.hg.LoginToGateHandlerGroup;
import com.funny.blood.net.gate.ClientToGateDispatcherScript;
import com.funny.blood.net.gate.LoginToGateDispatcherScript;

public class GateScriptGuiceModule extends RoomGuiceModule {
  @Override
  protected void bind() {
    bindSingleton(ILauncher.class, GateLauncher.class);

    bindSingleton(ClientToGateDispatcherScript.class);
    bindSingleton(LoginToGateDispatcherScript.class);
    bindSingleton(LoginToGateHandlerGroup.class);
  }
}
