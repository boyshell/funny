package com.funny.blood.server.room;

import com.funny.blood.GameGuiceModule;
import com.funny.blood.ILauncher;
import com.funny.blood.modules.hg.ClientToRoomHandlerGroup;
import com.funny.blood.modules.hg.GateToRoomHandlerGroup;
import com.funny.blood.modules.hg.HallToRoomHandlerGroup;
import com.funny.blood.server.room.room.GateToRoomDispatcherScript;
import com.funny.blood.server.room.room.HallToRoomDispatcherScript;

public class RoomScriptGuiceModule extends GameGuiceModule {
  @Override
  protected void bind() {
    bindSingleton(ILauncher.class, RoomLauncher.class);
    bindSingleton(GateToRoomDispatcherScript.class);
    bindSingleton(HallToRoomDispatcherScript.class);
    bindSingleton(GateToRoomHandlerGroup.class);
    bindSingleton(HallToRoomHandlerGroup.class);
    bindSingleton(UserInRoomModule.class);
    bindSingleton(ClientToRoomHandlerGroup.class);
  }
}
