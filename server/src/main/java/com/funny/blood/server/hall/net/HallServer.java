package com.funny.blood.server.hall.net;

import com.funny.blood.modules.base.room.GameType;
import com.funny.blood.server.hall.HallProperties;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import com.google.inject.Inject;
import io.netty.channel.Channel;
import shell.net.ByteToMessageHandler;
import shell.net.MessageToByteHandler;
import shell.net.TcpServer;

import java.util.function.Consumer;

public class HallServer extends TcpServer {
  private final HallDispatcher dispatcher;
  private final Table<GameType, Integer, RoomToHallUser> rooms =
      Tables.synchronizedTable(HashBasedTable.create());

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

  public Table<GameType, Integer, RoomToHallUser> getRooms() {
    return rooms;
  }
}
