package com.funny.blood.server.gate.net;

import com.funny.blood.modules.HallToGateMessageGroup;
import com.funny.blood.modules.base.net.ForwardClientToHallRequest;
import com.funny.blood.net.CommonClient;
import com.funny.blood.server.gate.GateProperties;
import com.google.inject.Inject;
import shell.net.ByteToMessageHandler;
import shell.net.Message;
import shell.net.MessageToByteHandler;
import shell.util.concurrent.SingleThreadFactory;

public class HallClient extends CommonClient {
  @Inject
  public HallClient(
      GateProperties properties,
      HallToGateDispatcher dispatcher,
      HallToGateMessageGroup messageGroup)
      throws Exception {
    super(
        "gate-to-hall-client",
        1,
        dispatcher,
        new SingleThreadFactory("gate-to-hall-client", Thread.MAX_PRIORITY),
        () -> new ByteToMessageHandler(messageGroup),
        () -> new MessageToByteHandler(),
        properties.HALL_HOST,
        properties.HALL_PORT);
  }

  public boolean forward(int userID, Message message) {
    return write(new ForwardClientToHallRequest(userID, Message.encodeToBytes(message)));
  }
}
