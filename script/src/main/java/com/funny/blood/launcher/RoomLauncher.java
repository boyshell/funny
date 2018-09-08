package com.funny.blood.launcher;

import com.funny.blood.ILauncher;
import com.funny.blood.net.room.GateToRoomDispatcherScript;
import com.funny.blood.net.room.HallClient;
import com.funny.blood.net.room.HallToRoomDispatcherScript;
import com.funny.blood.net.room.RoomServer;
import com.funny.blood.script.RoomScript;
import com.google.inject.Inject;

public class RoomLauncher implements ILauncher {
  private final RoomServer roomServer;
  private final GateToRoomDispatcherScript gateToRoomDispatcherScript;
  private final HallToRoomDispatcherScript hallToRoomDispatcherScript;
  private final RoomScript script;
  private final HallClient hallClient;

  @Inject
  public RoomLauncher(
      RoomServer roomServer,
      GateToRoomDispatcherScript gateToRoomDispatcherScript,
      HallToRoomDispatcherScript hallToRoomDispatcherScript,
      RoomScript script,
      HallClient hallClient) {
    this.roomServer = roomServer;
    this.gateToRoomDispatcherScript = gateToRoomDispatcherScript;
    this.hallToRoomDispatcherScript = hallToRoomDispatcherScript;
    this.script = script;
    this.hallClient = hallClient;
  }

  @Override
  public void launch() throws Exception {
    roomServer.startup();
    hallClient.startup();
  }

  @Override
  public void registerScript() {
    script.hallToRoomDispatcher = hallToRoomDispatcherScript;
    script.gateToRoomDispatcher = gateToRoomDispatcherScript;
  }
}
