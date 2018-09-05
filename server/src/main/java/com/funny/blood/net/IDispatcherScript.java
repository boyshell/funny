package com.funny.blood.net;

import io.netty.channel.Channel;
import shell.net.Message;

public interface IDispatcherScript {
  void tick(Channel channel, long now);

  void onChannelActive(Channel channel);

  void onChannelInactive(Channel channel);

  void onChannelRead(Channel channel, Message message);
}
