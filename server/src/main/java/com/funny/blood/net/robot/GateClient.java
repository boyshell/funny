package com.funny.blood.net.robot;

import com.funny.blood.properties.RobotProperties;
import com.google.inject.Inject;
import shell.net.BinaryWebSocketFrameToMessageHandler;
import shell.net.WebSocketClient;
import shell.util.concurrent.ThreadFactory;

public class GateClient extends WebSocketClient {
  //  @Inject
  //  public GateClient(RobotDispatcher dispatcher, MsgToClientFactory messageFactory)
  //      throws InterruptedException {
  //    super(
  //        "gate-client",
  //        Runtime.getRuntime().availableProcessors() * 2 + 1,
  //        dispatcher,
  //        new ThreadFactory("gate-client", Thread.MAX_PRIORITY),
  //        () -> new ByteToMessageHandler(messageFactory),
  //        () -> new MessageToByteHandler());
  //  }
  @Inject
  public GateClient(
      RobotDispatcher dispatcher, MsgToClientFactory messageFactory, RobotProperties properties) {
    super(
        "gate-client",
        Runtime.getRuntime().availableProcessors() * 2 + 1,
        new ThreadFactory("gate-client", Thread.MAX_PRIORITY),
        () -> new BinaryWebSocketFrameToMessageHandler(messageFactory),
        dispatcher,
        properties.GATE_HOST,
        properties.GATE_PORT);
  }
}
