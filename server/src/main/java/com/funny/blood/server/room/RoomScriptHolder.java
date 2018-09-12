package com.funny.blood.server.room;

import com.funny.blood.net.IDispatcherScript;

public class RoomScriptHolder {
  public volatile IDispatcherScript gateToRoomDispatcher;
  public volatile IDispatcherScript hallToRoomDispatcher;
}
