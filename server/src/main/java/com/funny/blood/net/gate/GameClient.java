package com.funny.blood.net.gate;

import com.funny.blood.modules.base.net.ForwardGateToGameRequest;
import com.funny.blood.net.CommonChannel;
import io.netty.channel.Channel;
import shell.net.Message;

public class GameClient extends CommonChannel {
  public GameClient(Channel channel) {
    super(channel);
  }

  public boolean forward(String channelID, Message message) {
    return write(new ForwardGateToGameRequest(channelID, Message.encodeToBytes(message)));
  }
}
