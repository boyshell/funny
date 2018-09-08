package com.funny.blood.launcher;

import com.funny.blood.ILauncher;
import com.funny.blood.net.gate.ClientToGateDispatcherScript;
import com.funny.blood.net.gate.GateServer;
import com.funny.blood.net.gate.HallToGateDispatcherScript;
import com.funny.blood.net.gate.LoginToGateDispatcherScript;
import com.funny.blood.script.GateScript;
import com.google.inject.Inject;

public class GateLauncher implements ILauncher {
  private final GateServer gateServer;
  private final GateScript gateScript;
  private final ClientToGateDispatcherScript clientToGateDispatcherScript;
  private final LoginToGateDispatcherScript loginToGateDispatcherScript;
  private final HallToGateDispatcherScript hallToGateDispatcherScript;

  @Inject
  public GateLauncher(
      GateServer gateServer,
      GateScript gateScript,
      ClientToGateDispatcherScript clientToGateDispatcherScript,
      LoginToGateDispatcherScript loginToGateDispatcherScript,
      HallToGateDispatcherScript hallToGateDispatcherScript) {
    this.gateServer = gateServer;
    this.gateScript = gateScript;
    this.clientToGateDispatcherScript = clientToGateDispatcherScript;
    this.loginToGateDispatcherScript = loginToGateDispatcherScript;
    this.hallToGateDispatcherScript = hallToGateDispatcherScript;
  }

  @Override
  public void launch() throws Exception {
    gateServer.startup();
  }

  @Override
  public void registerScript() {
    gateScript.client2gateDispatcher = clientToGateDispatcherScript;
    gateScript.login2gateDispatcher = loginToGateDispatcherScript;
    gateScript.hall2gateDispatcher = hallToGateDispatcherScript;
  }
}
