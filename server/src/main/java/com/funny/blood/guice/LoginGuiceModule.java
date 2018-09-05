package com.funny.blood.guice;

import com.funny.blood.GameGuiceModule;
import com.funny.blood.modules.ClientToLoginMessageGroup;
import com.funny.blood.modules.GateToLoginMessageGroup;
import com.funny.blood.modules.user.login.UserDataSet;
import com.funny.blood.net.login.GateToLoginDispatcher;
import com.funny.blood.net.login.LoginServer;
import com.funny.blood.properties.LoginProperties;
import com.funny.blood.script.LoginScript;
import com.funny.blood.shutdown.AbstractShutdownHooks;
import com.funny.blood.shutdown.LoginShutdownHooks;

public class LoginGuiceModule extends GameGuiceModule {
  @Override
  protected void bind() {
    bindSingleton(AbstractShutdownHooks.class, LoginShutdownHooks.class);
    bindSingleton(LoginServer.class);
    bindSingleton(LoginScript.class);
    bindSingleton(GateToLoginMessageGroup.class);
    bindSingleton(GateToLoginDispatcher.class);
    bindSingleton(LoginProperties.class);
    bindSingleton(ClientToLoginMessageGroup.class);
    bindSingleton(UserDataSet.class);
  }
}
