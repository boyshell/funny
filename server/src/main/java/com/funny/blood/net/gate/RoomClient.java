package com.funny.blood.net.gate;

import com.funny.blood.modules.base.net.ForwardGateToRoomRequest;
import com.funny.blood.net.CommonChannel;
import io.netty.channel.Channel;
import shell.net.Message;

public class RoomClient extends CommonChannel {
  public RoomClient(Channel channel) {
    super(channel);
  }

  public boolean forward(String channelID, Message message) {
    return write(new ForwardGateToRoomRequest(channelID, Message.encodeToBytes(message)));
  }
}
