package com.funny.blood.net.hall;

import com.funny.blood.properties.HallProperties;
import com.google.inject.Inject;
import io.netty.channel.Channel;
import shell.net.ByteToMessageHandler;
import shell.net.MessageToByteHandler;
import shell.net.TcpServer;

import java.util.function.Consumer;

public class HallServer extends TcpServer {
  private final HallDispatcher dispatcher;

  @Inject
  public HallServer(
      HallProperties properties,
      HallDispatcher dispatcher,
      GateAndRoomToHallFactory messageFactory) {
    super(
        "hall-server",
        properties.PORT,
        dispatcher,
        Runtime.getRuntime().availableProcessors() * 2 + 1,
        () -> new ByteToMessageHandler(messageFactory),
        () -> new MessageToByteHandler());
    this.dispatcher = dispatcher;
  }

  @Override
  protected void foreachLocalChannel(Consumer<Channel> consumer) {
    dispatcher.foreachChannel(consumer);
  }
}
