package com.funny.blood.server.room;

import com.funny.blood.GameGuiceModule;
import com.funny.blood.modules.ClientToRoomMessageGroup;
import com.funny.blood.modules.GateToRoomMessageGroup;
import com.funny.blood.modules.HallToRoomMessageGroup;
import com.funny.blood.server.room.net.GateToRoomDispatcher;
import com.funny.blood.server.room.net.HallClient;
import com.funny.blood.server.room.net.HallToRoomDispatcher;
import com.funny.blood.server.room.net.RoomServer;
import com.funny.blood.AbstractShutdownHooks;

public class RoomGuiceModule extends GameGuiceModule {
  @Override
  protected void bind() {
    bindSingleton(AbstractShutdownHooks.class, RoomShutdownHooks.class);
    bindSingleton(RoomServer.class);
    bindSingleton(RoomScriptHolder.class);
    bindSingleton(RoomProperties.class);
    bindSingleton(GateToRoomMessageGroup.class);
    bindSingleton(GateToRoomDispatcher.class);
    bindSingleton(ClientToRoomMessageGroup.class);
    bindSingleton(HallClient.class);
    bindSingleton(HallToRoomMessageGroup.class);
    bindSingleton(HallToRoomDispatcher.class);
  }
}
