package com.funny.blood.guice;

import com.funny.blood.RoomGuiceModule;
import com.funny.blood.ILauncher;
import com.funny.blood.launcher.LoginLauncher;
import com.funny.blood.modules.base.net.ForwardGateToLoginRequestHandler;
import com.funny.blood.modules.base.user.UserModule;
import com.funny.blood.modules.hg.ClientToLoginHandlerGroup;
import com.funny.blood.modules.hg.GateToLoginHandlerGroup;
import com.funny.blood.net.login.GateToLoginDispatcherScript;

public class LoginScriptGuiceModule extends RoomGuiceModule {
  @Override
  protected void bind() {
    bindSingleton(ILauncher.class, LoginLauncher.class);
    bindSingleton(GateToLoginDispatcherScript.class);
    bindSingleton(GateToLoginHandlerGroup.class);
    bindSingleton(ForwardGateToLoginRequestHandler.class);
    bindSingleton(ClientToLoginHandlerGroup.class);
    bindSingleton(UserModule.class);
  }
}
