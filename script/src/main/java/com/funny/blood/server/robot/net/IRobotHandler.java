package com.funny.blood.server.robot.net;

import com.funny.blood.server.robot.net.RobotUser;
import shell.net.Message;

public interface IRobotHandler<T extends Message> {
  void exec(RobotUser user, T message);
}
