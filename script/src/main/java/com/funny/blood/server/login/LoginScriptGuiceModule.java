package com.funny.blood.server.login;

import com.funny.blood.ILauncher;
import com.funny.blood.GameGuiceModule;
import com.funny.blood.modules.hg.ClientToLoginHandlerGroup;
import com.funny.blood.modules.hg.GateToLoginHandlerGroup;
import com.funny.blood.server.login.net.GateToLoginDispatcherScript;

public class LoginScriptGuiceModule extends GameGuiceModule {
  @Override
  protected void bind() {
    bindSingleton(ILauncher.class, LoginLauncher.class);
    bindSingleton(GateToLoginDispatcherScript.class);
    bindSingleton(GateToLoginHandlerGroup.class);
    bindSingleton(ClientToLoginHandlerGroup.class);
    bindSingleton(UserInLoginModule.class);
  }
}
