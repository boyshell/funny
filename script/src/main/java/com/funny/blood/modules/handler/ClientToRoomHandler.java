package com.funny.blood.modules.handler;

import com.funny.blood.modules.user.room.UserInRoom;
import shell.net.Message;

public interface ClientToRoomHandler<T extends Message> {
  void exec(UserInRoom user, T decode);
}
