package com.funny.blood.modules.handler;

import io.netty.channel.Channel;
import shell.net.Message;

public interface HallToGateHandler<T extends Message> {
  void exec(Channel channel, T message);
}
