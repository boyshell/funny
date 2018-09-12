package com.funny.blood.server.hall.net;

import com.funny.blood.modules.GateToHallMessageGroup;
import com.funny.blood.modules.RoomToHallMessageGroup;
import com.funny.blood.net.MessageGroup;
import com.google.inject.Inject;

public class GateAndRoomToHallFactory extends MessageGroup {
  @Inject
  public GateAndRoomToHallFactory(
      GateToHallMessageGroup gateToHallMessageGroup,
      RoomToHallMessageGroup roomToHallMessageGroup) {
    super(gateToHallMessageGroup.messages, roomToHallMessageGroup.messages);
  }
}
