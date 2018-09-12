package com.funny.blood.server.gate.net;

import com.funny.blood.net.CommonChannel;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shell.net.Message;

public class RoomClient extends CommonChannel {
  private static final Logger logger = LoggerFactory.getLogger(RoomClient.class);
  public RoomClient(Channel channel) {
    super(channel);
  }

  public void write(ClientToGateUser user, Message message) {
    if (user == null) {
      logger.error("user is null!", new NullPointerException());
      return;
    }
    ClientToGateUser.Room room = user.getRoom();
    if (room == null) {
      logger.warn("room is null!{}", user, new NullPointerException());
      return;
    }
//    Channel roomChannel = getRoomChannel(room);
//    if (roomChannel == null) {
//
//    }
    // todo 进入房间的流程需要整理下!
  }
}
