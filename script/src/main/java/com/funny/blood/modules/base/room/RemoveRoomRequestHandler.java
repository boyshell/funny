package com.funny.blood.modules.base.room;

import com.funny.blood.modules.handler.HallToGateHandler;
import io.netty.channel.Channel;

public class RemoveRoomRequestHandler implements HallToGateHandler<RemoveRoomRequest> {
  @Override
  public void exec(Channel channel, RemoveRoomRequest message) {}
}
