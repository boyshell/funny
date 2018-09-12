package com.funny.blood.server.room;

import com.funny.blood.modules.user.room.UserInRoom;
import com.funny.blood.modules.user.room.UserInRoomDataSet;
import com.funny.blood.server.room.worker.UserInRoomTask;
import com.google.inject.Inject;

public class UserInRoomModule {
  private final UserInRoomDataSet dataSet;

  @Inject
  public UserInRoomModule(UserInRoomDataSet dataSet) {
    this.dataSet = dataSet;
  }

  public void exec(int userID, UserInRoomTask task) {
    UserInRoom user = dataSet.getUsers().get(userID);
    if (user == null) {
      // todo
      return;
    }
    // todo 需要选择线程
  }
}
