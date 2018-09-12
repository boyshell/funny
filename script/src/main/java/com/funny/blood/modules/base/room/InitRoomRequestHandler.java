package com.funny.blood.modules.base.room;

import com.funny.blood.modules.handler.HallToGateHandler;
import io.netty.channel.Channel;

public class InitRoomRequestHandler implements HallToGateHandler<InitRoomRequest> {
  @Override
  public void exec(Channel channel, InitRoomRequest message) {}
}
