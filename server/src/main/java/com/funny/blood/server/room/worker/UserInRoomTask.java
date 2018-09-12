package com.funny.blood.server.room.worker;

import com.funny.blood.modules.user.room.UserInRoom;
import com.funny.blood.woker.UserTask;

public abstract class UserInRoomTask extends UserTask<UserInRoom> {
  public UserInRoomTask(String name) {
    super(name);
  }
}
