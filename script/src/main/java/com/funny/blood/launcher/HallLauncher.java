package com.funny.blood.launcher;

import com.funny.blood.ILauncher;
import com.funny.blood.net.hall.GateAndRoomToHallDispatcherScript;
import com.funny.blood.net.hall.HallServer;
import com.funny.blood.script.HallScript;
import com.google.inject.Inject;

public class HallLauncher implements ILauncher {
  private final HallServer hallServer;
  private final GateAndRoomToHallDispatcherScript gateAndRoomToHallDispatcherScript;
  private final HallScript hallScript;

  @Inject
  public HallLauncher(
      HallServer hallServer,
      GateAndRoomToHallDispatcherScript gateAndRoomToHallDispatcherScript,
      HallScript hallScript) {
    this.hallServer = hallServer;
    this.gateAndRoomToHallDispatcherScript = gateAndRoomToHallDispatcherScript;
    this.hallScript = hallScript;
  }

  @Override
  public void launch() throws Exception {
    hallServer.startup();
  }

  @Override
  public void registerScript() {
    hallScript.gateAndRoom2hallDispatcher = gateAndRoomToHallDispatcherScript;
  }
}
