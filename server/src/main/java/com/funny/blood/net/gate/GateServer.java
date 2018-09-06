package com.funny.blood.net.gate;

import com.funny.blood.properties.GateProperties;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import io.netty.channel.Channel;
import shell.net.BinaryWebSocketFrameToMessageHandler;
import shell.net.WebSocketServer;
import shell.util.concurrent.SingleThreadFactory;
import shell.util.concurrent.ThreadFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class GateServer extends WebSocketServer {
  private final ClientToGateDispatcher dispatcher;

  private final Map<String, ClientToGateUser> channels = new ConcurrentHashMap<>();
  private final BiMap<String, Integer> channelID2userID =
      Maps.synchronizedBiMap(HashBiMap.create());

  @Inject
  public GateServer(
      GateProperties properties,
      MsgFromClientFactory msgFactory,
      ClientToGateDispatcher dispatcher) {
    super(
        "gate-server",
        properties.PORT,
        Runtime.getRuntime().availableProcessors() * 2 + 1,
        () -> new BinaryWebSocketFrameToMessageHandler(msgFactory),
        dispatcher,
        60,
        new SingleThreadFactory("logic-server-boss", Thread.MAX_PRIORITY),
        new ThreadFactory("logic-server-worker", Thread.MAX_PRIORITY));
    this.dispatcher = dispatcher;
  }

  @Override
  protected void foreachLocalChannel(Consumer<Channel> consumer) {
    dispatcher.foreachChannel(consumer);
  }

  public Map<String, ClientToGateUser> getChannels() {
    return channels;
  }

  public BiMap<String, Integer> getChannelID2userID() {
    return channelID2userID;
  }
}
