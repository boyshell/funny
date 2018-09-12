package com.funny.blood.modules.base.room;

import com.funny.blood.modules.handler.HallToGateHandler;
import io.netty.channel.Channel;

public class BindRoomRequestHandler implements HallToGateHandler<BindRoomRequest> {
  @Override
  public void exec(Channel channel, BindRoomRequest message) {
    // todo
  }
}
