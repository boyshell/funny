package com.funny.blood.modules.base.room;

import com.funny.blood.modules.handler.ClientToHallHandler;
import com.funny.blood.modules.user.hall.UserInHall;
import com.funny.blood.server.hall.net.HallServer;
import com.funny.blood.server.hall.net.RoomToHallUser;
import com.google.inject.Inject;

public class EnterRoomRequestHandler implements ClientToHallHandler<EnterRoomRequest> {
  private final HallServer hallServer;

  @Inject
  public EnterRoomRequestHandler(HallServer hallServer) {
    this.hallServer = hallServer;
  }

  @Override
  public void exec(UserInHall user, EnterRoomRequest message) {
    RoomToHallUser room = user.getRoom();
    if (room != null) {
      user.write(EnterRoomError.IN_ROOM);
      return;
    }
    room = hallServer.getRooms().get(message.getGameType(), message.getRoomID());
    if (room == null) {
      user.write(EnterRoomError.NO_ROOM);
      return;
    }
    // todo 如果房间挂了咋个整？
    // todo 这里会有小概率出现问题，在房间关闭的瞬间进入房间的时候。当然可以不管这个问题。让前端重连就好了。
    if (room.getNum() >= room.getMax()) {
      user.write(EnterRoomError.FULL);
      return;
    }
    // todo 前端自己记录时间做超时处理就好了
    room.write(new AddUserRequest(user.getId()));
  }
}
