package com.funny.blood.modules.base.room;

import com.funny.blood.modules.handler.HallToGateHandler;
import io.netty.channel.Channel;

public class AddRoomRequestHandler implements HallToGateHandler<AddRoomRequest> {
  @Override
  public void exec(Channel channel, AddRoomRequest message) {}
}
