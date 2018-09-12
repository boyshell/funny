package com.funny.blood.server.gate.net;

import com.funny.blood.modules.LoginToGateMessageGroup;
import com.funny.blood.net.CommonClient;
import com.funny.blood.server.gate.GateProperties;
import com.google.inject.Inject;
import shell.net.ByteToMessageHandler;
import shell.net.MessageToByteHandler;
import shell.util.concurrent.SingleThreadFactory;

public class LoginClient extends CommonClient {

  @Inject
  public LoginClient(
      GateProperties properties,
      LoginToGateDispatcher dispatcher,
      LoginToGateMessageGroup messageGroup)
      throws Exception {
    super(
        "gate-to-login-client",
        1,
        dispatcher,
        new SingleThreadFactory("gate-to-login-client", Thread.MAX_PRIORITY),
        () -> new ByteToMessageHandler(messageGroup),
        () -> new MessageToByteHandler(),
        properties.LOGIN_HOST,
        properties.LOGIN_PORT);
  }
}
