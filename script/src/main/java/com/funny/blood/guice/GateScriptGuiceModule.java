package com.funny.blood.guice;

import com.funny.blood.GameGuiceModule;
import com.funny.blood.ILauncher;
import com.funny.blood.launcher.GateLauncher;
import com.funny.blood.modules.hg.HallToGateHandlerGroup;
import com.funny.blood.modules.hg.LoginToGateHandlerGroup;
import com.funny.blood.net.gate.ClientToGateDispatcherScript;
import com.funny.blood.net.gate.HallToGateDispatcherScript;
import com.funny.blood.net.gate.LoginToGateDispatcherScript;

public class GateScriptGuiceModule extends GameGuiceModule {
  @Override
  protected void bind() {
    bindSingleton(ILauncher.class, GateLauncher.class);

    bindSingleton(ClientToGateDispatcherScript.class);
    bindSingleton(LoginToGateDispatcherScript.class);
    bindSingleton(LoginToGateHandlerGroup.class);
    bindSingleton(HallToGateDispatcherScript.class);
    bindSingleton(HallToGateHandlerGroup.class);
  }
}
