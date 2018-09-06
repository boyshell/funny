package com.funny.blood.net.login;

import com.funny.blood.modules.GateToLoginMessageGroup;
import com.funny.blood.properties.LoginProperties;
import com.google.inject.Inject;
import io.netty.channel.Channel;
import shell.net.ByteToMessageHandler;
import shell.net.MessageToByteHandler;
import shell.net.TcpServer;

import java.util.function.Consumer;

public class LoginServer extends TcpServer {
  private final GateToLoginDispatcher dispatcher;

  @Inject
  public LoginServer(
      LoginProperties properties,
      GateToLoginDispatcher dispatcher,
      GateToLoginMessageGroup messageGroup) {
    super(
        "login-server",
        properties.PORT,
        dispatcher,
        Runtime.getRuntime().availableProcessors() * 2 + 1,
        () -> new ByteToMessageHandler(messageGroup),
        () -> new MessageToByteHandler());
    this.dispatcher = dispatcher;
  }

  @Override
  protected void foreachLocalChannel(Consumer<Channel> consumer) {
    dispatcher.foreachChannel(consumer);
  }
}
