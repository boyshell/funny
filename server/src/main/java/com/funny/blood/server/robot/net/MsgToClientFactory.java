package com.funny.blood.server.robot.net;

import com.funny.blood.modules.GateToClientMessageGroup;
import com.funny.blood.modules.HallToClientMessageGroup;
import com.funny.blood.modules.LoginToClientMessageGroup;
import com.funny.blood.modules.RoomToClientMessageGroup;
import com.funny.blood.net.MessageGroup;
import com.google.inject.Inject;

public class MsgToClientFactory extends MessageGroup {
  @Inject
  public MsgToClientFactory(
      GateToClientMessageGroup gateToClientMessageGroup,
      LoginToClientMessageGroup loginToClientMessageGroup,
      RoomToClientMessageGroup roomToClientMessageGroup,
      HallToClientMessageGroup hallToClientMessageGroup) {
    super(
        gateToClientMessageGroup.messages,
        loginToClientMessageGroup.messages,
        roomToClientMessageGroup.messages,
        hallToClientMessageGroup.messages);
  }
}
