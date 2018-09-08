package com.funny.blood.launcher;

import com.funny.blood.ILauncher;
import com.funny.blood.net.gate.*;
import com.funny.blood.script.GateScript;
import com.google.inject.Inject;

public class GateLauncher implements ILauncher {
  private final GateServer gateServer;
  private final GateScript gateScript;
  private final ClientToGateDispatcherScript clientToGateDispatcherScript;
  private final LoginToGateDispatcherScript loginToGateDispatcherScript;
  private final HallToGateDispatcherScript hallToGateDispatcherScript;
  private final HallClient hallClient;
  private final LoginClient loginClient;

  @Inject
  public GateLauncher(
      GateServer gateServer,
      GateScript gateScript,
      ClientToGateDispatcherScript clientToGateDispatcherScript,
      LoginToGateDispatcherScript loginToGateDispatcherScript,
      HallToGateDispatcherScript hallToGateDispatcherScript,
      HallClient hallClient,
      LoginClient loginClient) {
    this.gateServer = gateServer;
    this.gateScript = gateScript;
    this.clientToGateDispatcherScript = clientToGateDispatcherScript;
    this.loginToGateDispatcherScript = loginToGateDispatcherScript;
    this.hallToGateDispatcherScript = hallToGateDispatcherScript;
    this.hallClient = hallClient;
    this.loginClient = loginClient;
  }

  @Override
  public void launch() throws Exception {
    gateServer.startup();
    hallClient.startup();
    loginClient.startup();
  }

  @Override
  public void registerScript() {
    gateScript.client2gateDispatcher = clientToGateDispatcherScript;
    gateScript.login2gateDispatcher = loginToGateDispatcherScript;
    gateScript.hall2gateDispatcher = hallToGateDispatcherScript;
  }
}
