package com.funny.blood.server.gate;

import com.funny.blood.net.IDispatcherScript;

public class GateScriptHolder {
  public volatile IDispatcherScript client2gateDispatcher;
  public volatile IDispatcherScript login2gateDispatcher;
  public volatile IDispatcherScript hall2gateDispatcher;
}
