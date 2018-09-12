package com.funny.blood.server.gate;

import com.funny.blood.GameGuiceModule;
import com.funny.blood.ILauncher;
import com.funny.blood.modules.hg.HallToGateHandlerGroup;
import com.funny.blood.modules.hg.LoginToGateHandlerGroup;
import com.funny.blood.server.gate.net.ClientToGateDispatcherScript;
import com.funny.blood.server.gate.net.HallToGateDispatcherScript;
import com.funny.blood.server.gate.net.LoginToGateDispatcherScript;

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
