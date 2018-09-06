package com.funny.blood.net.robot;

import shell.net.Message;

public interface IRobotHandler<T extends Message> {
  void exec(RobotUser user, T message);
}
