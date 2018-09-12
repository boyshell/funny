package com.funny.blood.modules.base.room;

import com.funny.blood.modules.handler.HallToClientHandler;
import com.funny.blood.server.robot.net.RobotUser;

public class EnterRoomResponseHandler implements HallToClientHandler<EnterRoomResponse> {
  @Override
  public void exec(RobotUser user, EnterRoomResponse message) {}
}
