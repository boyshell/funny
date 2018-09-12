package com.funny.blood.server.gate;

import com.funny.blood.ILauncher;
import com.funny.blood.server.gate.net.*;
import com.google.inject.Inject;

public class GateLauncher implements ILauncher {
  private final GateServer gateServer;
  private final GateScriptHolder gateScriptHolder;
  private final ClientToGateDispatcherScript clientToGateDispatcherScript;
  private final LoginToGateDispatcherScript loginToGateDispatcherScript;
  private final HallToGateDispatcherScript hallToGateDispatcherScript;
  private final HallClient hallClient;
  private final LoginClient loginClient;

  @Inject
  public GateLauncher(
      GateServer gateServer,
      GateScriptHolder gateScriptHolder,
      ClientToGateDispatcherScript clientToGateDispatcherScript,
      LoginToGateDispatcherScript loginToGateDispatcherScript,
      HallToGateDispatcherScript hallToGateDispatcherScript,
      HallClient hallClient,
      LoginClient loginClient) {
    this.gateServer = gateServer;
    this.gateScriptHolder = gateScriptHolder;
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
    gateScriptHolder.client2gateDispatcher = clientToGateDispatcherScript;
    gateScriptHolder.login2gateDispatcher = loginToGateDispatcherScript;
    gateScriptHolder.hall2gateDispatcher = hallToGateDispatcherScript;
  }
}
