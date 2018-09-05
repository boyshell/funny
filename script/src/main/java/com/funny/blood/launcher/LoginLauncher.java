package com.funny.blood.launcher;

import com.funny.blood.ILauncher;
import com.funny.blood.net.login.GateToLoginDispatcherScript;
import com.funny.blood.net.login.LoginServer;
import com.funny.blood.script.LoginScript;
import com.google.inject.Inject;

public class LoginLauncher implements ILauncher {
  private final LoginServer loginServer;
  private final LoginScript loginScript;
  private final GateToLoginDispatcherScript dispatcherScript;

  @Inject
  public LoginLauncher(
      LoginServer loginServer,
      LoginScript loginScript,
      GateToLoginDispatcherScript dispatcherScript) {
    this.loginServer = loginServer;
    this.loginScript = loginScript;
    this.dispatcherScript = dispatcherScript;
  }

  @Override
  public void launch() throws Exception {
    loginServer.startup();
  }

  @Override
  public void registerScript() {
    loginScript.gate2loginDispatcher = dispatcherScript;
  }
}
