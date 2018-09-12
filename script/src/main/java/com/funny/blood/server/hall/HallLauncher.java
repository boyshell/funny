package com.funny.blood.server.hall;

import com.funny.blood.ILauncher;
import com.funny.blood.server.hall.net.GateAndRoomToHallDispatcherScript;
import com.funny.blood.server.hall.net.HallServer;
import com.google.inject.Inject;

public class HallLauncher implements ILauncher {
  private final HallServer hallServer;
  private final GateAndRoomToHallDispatcherScript gateAndRoomToHallDispatcherScript;
  private final HallScriptHolder hallScriptHolder;

  @Inject
  public HallLauncher(
      HallServer hallServer,
      GateAndRoomToHallDispatcherScript gateAndRoomToHallDispatcherScript,
      HallScriptHolder hallScriptHolder) {
    this.hallServer = hallServer;
    this.gateAndRoomToHallDispatcherScript = gateAndRoomToHallDispatcherScript;
    this.hallScriptHolder = hallScriptHolder;
  }

  @Override
  public void launch() throws Exception {
    hallServer.startup();
  }

  @Override
  public void registerScript() {
    hallScriptHolder.gateAndRoom2hallDispatcher = gateAndRoomToHallDispatcherScript;
  }
}
