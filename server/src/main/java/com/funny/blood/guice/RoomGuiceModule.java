package com.funny.blood.guice;

import com.funny.blood.GameGuiceModule;
import com.funny.blood.modules.ClientToRoomMessageGroup;
import com.funny.blood.modules.GateToRoomMessageGroup;
import com.funny.blood.modules.HallToRoomMessageGroup;
import com.funny.blood.net.room.GateToRoomDispatcher;
import com.funny.blood.net.room.HallClient;
import com.funny.blood.net.room.HallToRoomDispatcher;
import com.funny.blood.net.room.RoomServer;
import com.funny.blood.properties.RoomProperties;
import com.funny.blood.script.RoomScript;
import com.funny.blood.shutdown.AbstractShutdownHooks;
import com.funny.blood.shutdown.RoomShutdownHooks;

public class RoomGuiceModule extends GameGuiceModule {
  @Override
  protected void bind() {
    bindSingleton(AbstractShutdownHooks.class, RoomShutdownHooks.class);
    bindSingleton(RoomServer.class);
    bindSingleton(RoomScript.class);
    bindSingleton(RoomProperties.class);
    bindSingleton(GateToRoomMessageGroup.class);
    bindSingleton(GateToRoomDispatcher.class);
    bindSingleton(ClientToRoomMessageGroup.class);
    bindSingleton(HallClient.class);
    bindSingleton(HallToRoomMessageGroup.class);
    bindSingleton(HallToRoomDispatcher.class);
  }
}
