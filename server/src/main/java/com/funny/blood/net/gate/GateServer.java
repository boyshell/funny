package com.funny.blood.net.gate;

import com.funny.blood.properties.GateProperties;
import com.google.inject.Inject;
import shell.net.WebSocketServer;
import shell.net.WebSocketServerInitializer;
import shell.util.concurrent.SingleThreadFactory;
import shell.util.concurrent.ThreadFactory;

public class GateServer extends WebSocketServer {
  @Inject
  public GateServer(
      GateProperties properties,
      MsgFromClientFactory msgFactory,
      ClientToGateDispatcher dispatcher) {
    super(
        "gate-server",
        properties.PORT,
        Runtime.getRuntime().availableProcessors() * 2 + 1,
        () -> new WebSocketServerInitializer.BinaryWebSocketFrameToMessageHandler(msgFactory),
        dispatcher,
        60,
        new SingleThreadFactory("logic-server-boss", Thread.MAX_PRIORITY),
        new ThreadFactory("logic-server-worker", Thread.MAX_PRIORITY));
  }
}
