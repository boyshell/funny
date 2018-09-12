package com.funny.blood.modules.handler;

import com.funny.blood.modules.user.hall.UserInHall;
import shell.net.Message;

public interface ClientToHallHandler<T extends Message> {
  void exec(UserInHall user, T message);
}
