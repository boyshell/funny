package com.funny.blood.net.room;

import com.funny.blood.modules.HallToRoomMessageGroup;
import com.funny.blood.net.CommonClient;
import com.funny.blood.properties.RoomProperties;
import com.google.inject.Inject;
import shell.net.ByteToMessageHandler;
import shell.net.MessageToByteHandler;
import shell.util.concurrent.SingleThreadFactory;

public class HallClient extends CommonClient {
  @Inject
  public HallClient(
      HallToRoomDispatcher dispatcher,
      HallToRoomMessageGroup messageGroup,
      RoomProperties properties)
      throws Exception {
    super(
        "room-to-hall-client",
        1,
        dispatcher,
        new SingleThreadFactory("room-to-hall-client", Thread.MAX_PRIORITY),
        () -> new ByteToMessageHandler(messageGroup),
        () -> new MessageToByteHandler(),
        properties.HALL_HOST,
        properties.HALL_PORT);
  }
}
