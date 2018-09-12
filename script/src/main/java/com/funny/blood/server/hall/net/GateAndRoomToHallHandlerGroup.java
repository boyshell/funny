package com.funny.blood.server.hall.net;

import com.funny.blood.modules.hg.GateToHallHandlerGroup;
import com.funny.blood.modules.hg.RoomToHallHandlerGroup;
import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;

import java.util.HashMap;
import java.util.Map;

public class GateAndRoomToHallHandlerGroup {
  public final ImmutableMap<Integer, IGateAndRoomToHallHandler> handlers;

  @Inject
  public GateAndRoomToHallHandlerGroup(
      GateToHallHandlerGroup gateToHallHandlerGroup,
      RoomToHallHandlerGroup roomToHallHandlerGroup) {
    Map<Integer, IGateAndRoomToHallHandler> map = new HashMap<>();
    map.putAll(gateToHallHandlerGroup.handlers);
    map.putAll(roomToHallHandlerGroup.handlers);

    handlers = ImmutableMap.copyOf(map);
  }

  public IGateAndRoomToHallHandler handler(int id) {
    return handlers.get(id);
  }
}
