package com.funny.blood.net.gate;

import com.funny.blood.modules.LoginToGateMessageGroup;
import com.funny.blood.modules.base.net.ForwardGateToLoginRequest;
import com.funny.blood.net.CommonClient;
import com.funny.blood.properties.GateProperties;
import com.google.inject.Inject;
import shell.net.ByteToMessageHandler;
import shell.net.Message;
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

  public boolean forward(String channelID, Message message) {
    return write(new ForwardGateToLoginRequest(channelID, Message.encodeToBytes(message)));
  }
}
