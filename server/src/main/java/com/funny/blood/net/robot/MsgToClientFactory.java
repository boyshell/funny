package com.funny.blood.net.robot;

import com.funny.blood.modules.GameToClientMessageGroup;
import com.funny.blood.modules.GateToClientMessageGroup;
import com.funny.blood.modules.HallToClientMessageGroup;
import com.funny.blood.modules.LoginToClientMessageGroup;
import com.funny.blood.net.MessageGroup;
import com.google.inject.Inject;

public class MsgToClientFactory extends MessageGroup {
  @Inject
  public MsgToClientFactory(
      GateToClientMessageGroup gateToClientMessageGroup,
      LoginToClientMessageGroup loginToClientMessageGroup,
      GameToClientMessageGroup gameToClientMessageGroup,
      HallToClientMessageGroup hallToClientMessageGroup) {
    super(
        gateToClientMessageGroup.messages,
        loginToClientMessageGroup.messages,
        gameToClientMessageGroup.messages,
        hallToClientMessageGroup.messages);
  }
}
