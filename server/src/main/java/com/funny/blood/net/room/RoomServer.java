package com.funny.blood.net.room;

import com.funny.blood.modules.GateToRoomMessageGroup;
import com.funny.blood.properties.RoomProperties;
import com.google.inject.Inject;
import io.netty.channel.Channel;
import shell.net.ByteToMessageHandler;
import shell.net.MessageToByteHandler;
import shell.net.TcpServer;

import java.util.function.Consumer;

public class RoomServer extends TcpServer {
  private final GateToRoomDispatcher dispatcher;

  @Inject
  public RoomServer(
      RoomProperties properties,
      GateToRoomDispatcher dispatcher,
      GateToRoomMessageGroup messageGroup) {
    super(
        "room-server",
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
