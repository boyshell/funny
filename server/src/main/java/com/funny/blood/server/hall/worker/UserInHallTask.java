package com.funny.blood.server.hall.worker;

import com.funny.blood.modules.user.hall.UserInHall;
import com.funny.blood.woker.UserTask;
import shell.time.TimeUtil;

public abstract class UserInHallTask extends UserTask<UserInHall> {
  public UserInHallTask(String name) {
    super(name);
  }

  @Override
  public void exec(UserInHall user) {
    user.setLastActiveTime(TimeUtil.millis());
    exec0(user);
  }

  public abstract void exec0(UserInHall user);
}
