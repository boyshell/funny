package com.funny.blood.modules.handler;

import com.funny.blood.modules.user.hall.UserInHall;
import shell.net.Message;

public interface ClientToHallHandler {
  void exec(UserInHall user, Message message);
}
