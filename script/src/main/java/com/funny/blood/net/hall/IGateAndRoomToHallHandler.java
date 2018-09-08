package com.funny.blood.net.hall;

import io.netty.channel.Channel;
import shell.net.Message;

public interface IGateAndRoomToHallHandler<T extends Message> {
  void exec(Channel channel, T message);
}
