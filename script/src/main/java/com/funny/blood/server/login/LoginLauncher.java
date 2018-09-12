package com.funny.blood.server.login;

import com.funny.blood.ILauncher;
import com.funny.blood.server.login.net.GateToLoginDispatcherScript;
import com.funny.blood.server.login.net.LoginServer;
import com.google.inject.Inject;

public class LoginLauncher implements ILauncher {
  private final LoginServer loginServer;
  private final LoginScriptHolder loginScriptHolder;
  private final GateToLoginDispatcherScript dispatcherScript;

  @Inject
  public LoginLauncher(
      LoginServer loginServer,
      LoginScriptHolder loginScriptHolder,
      GateToLoginDispatcherScript dispatcherScript) {
    this.loginServer = loginServer;
    this.loginScriptHolder = loginScriptHolder;
    this.dispatcherScript = dispatcherScript;
  }

  @Override
  public void launch() throws Exception {
    loginServer.startup();
  }

  @Override
  public void registerScript() {
    loginScriptHolder.gate2loginDispatcher = dispatcherScript;
  }
}
