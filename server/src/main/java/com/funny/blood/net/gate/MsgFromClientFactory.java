package com.funny.blood.net.gate;

import com.funny.blood.modules.ClientToGameMessageGroup;
import com.funny.blood.modules.ClientToGateMessageGroup;
import com.funny.blood.modules.ClientToHallMessageGroup;
import com.funny.blood.modules.ClientToLoginMessageGroup;
import com.funny.blood.net.MessageGroup;
import com.google.inject.Inject;

public class MsgFromClientFactory extends MessageGroup {
  @Inject
  public MsgFromClientFactory(
      ClientToLoginMessageGroup clientToLoginMessageGroup,
      ClientToGateMessageGroup clientToGateMessageGroup,
      ClientToGameMessageGroup clientToGameMessageGroup,
      ClientToHallMessageGroup clientToHallMessageGroup) {
    super(
        clientToLoginMessageGroup.messages,
        clientToGateMessageGroup.messages,
        clientToGameMessageGroup.messages,
        clientToHallMessageGroup.messages);
  }
}
