package com.funny.blood.modules.base.room;

import com.funny.blood.modules.handler.HallToRoomHandler;
import com.funny.blood.modules.user.room.UserInRoom;
import com.funny.blood.modules.user.room.UserInRoomDataSet;
import com.funny.blood.server.room.RoomProperties;
import com.google.inject.Inject;
import io.netty.channel.Channel;
import shell.net.NetUtil;

public class AddUserRequestHandler implements HallToRoomHandler<AddUserRequest> {
  private final RoomProperties properties;
  private final UserInRoomDataSet userInRoomDataSet;

  @Inject
  public AddUserRequestHandler(RoomProperties properties, UserInRoomDataSet userInRoomDataSet) {
    this.properties = properties;
    this.userInRoomDataSet = userInRoomDataSet;
  }

  @Override
  public void exec(Channel channel, AddUserRequest message) {
    if (userInRoomDataSet.getUsers().size() >= properties.MAX) {
      NetUtil.write(channel, new AddUserResponse(message.getUserID(), false));
      return;
    }
    UserInRoom user = new UserInRoom(message.getUserID());
    userInRoomDataSet.getUsers().put(user.getId(), user);
    NetUtil.write(channel, new AddUserResponse(user.getId(), true));

    // todo 找桌子坐下去，然后发给前端桌子信息,也就是设置
  }
}
