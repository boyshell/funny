package com.funny.blood.modules.poker.ddz;

import com.funny.blood.modules.handler.GameToClientHandler;
import com.funny.blood.net.robot.RobotUser;

public class Test1RequestHandler implements GameToClientHandler<Test1Request> {
  @Override
  public void exec(RobotUser user, Test1Request message) {}
}
