package com.funny.blood.server.room;

import com.funny.blood.ILauncher;
import com.funny.blood.server.room.room.GateToRoomDispatcherScript;
import com.funny.blood.server.room.net.HallClient;
import com.funny.blood.server.room.room.HallToRoomDispatcherScript;
import com.funny.blood.server.room.net.RoomServer;
import com.google.inject.Inject;

public class RoomLauncher implements ILauncher {
  private final RoomServer roomServer;
  private final GateToRoomDispatcherScript gateToRoomDispatcherScript;
  private final HallToRoomDispatcherScript hallToRoomDispatcherScript;
  private final RoomScriptHolder script;
  private final HallClient hallClient;

  @Inject
  public RoomLauncher(
      RoomServer roomServer,
      GateToRoomDispatcherScript gateToRoomDispatcherScript,
      HallToRoomDispatcherScript hallToRoomDispatcherScript,
      RoomScriptHolder script,
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
