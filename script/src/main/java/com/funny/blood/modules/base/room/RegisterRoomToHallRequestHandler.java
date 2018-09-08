package com.funny.blood.modules.base.room;

import com.funny.blood.modules.handler.RoomToHallHandler;
import com.funny.blood.net.hall.HallServer;
import com.funny.blood.net.hall.RoomToHallUser;
import com.google.inject.Inject;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegisterRoomToHallRequestHandler
    implements RoomToHallHandler<RegisterRoomToHallRequest> {
  private static final Logger logger =
      LoggerFactory.getLogger(RegisterRoomToHallRequestHandler.class);
  private final HallServer hallServer;

  @Inject
  public RegisterRoomToHallRequestHandler(HallServer hallServer) {
    this.hallServer = hallServer;
  }

  @Override
  public void exec(Channel channel, RegisterRoomToHallRequest message) {
    logger.info("register:{}", message);
    RoomToHallUser user = channel.attr(RoomToHallUser.KEY).get();
    if (user != null) {
      logger.error("user is not null:{}", user, new IllegalArgumentException());
      return;
    }
    user =
        new RoomToHallUser(
            channel,
            message.getType(),
            message.getId(),
            message.getHost(),
            message.getPort(),
            message.getMax(),
            message.getNeedChip());
    RoomToHallUser oldUser = hallServer.getRooms().put(user.getType(), user.getId(), user);
    if (oldUser != null) {
      oldUser.close("replace");
    }
  }
}
