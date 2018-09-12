package com.funny.blood.server.gate.net;

import com.funny.blood.modules.ClientToGateMessageGroup;
import com.funny.blood.modules.ClientToHallMessageGroup;
import com.funny.blood.modules.ClientToLoginMessageGroup;
import com.funny.blood.modules.ClientToRoomMessageGroup;
import com.funny.blood.net.MessageGroup;
import com.google.inject.Inject;

public class MsgFromClientFactory extends MessageGroup {
  @Inject
  public MsgFromClientFactory(
      ClientToLoginMessageGroup clientToLoginMessageGroup,
      ClientToGateMessageGroup clientToGateMessageGroup,
      ClientToRoomMessageGroup clientToRoomMessageGroup,
      ClientToHallMessageGroup clientToHallMessageGroup) {
    super(
        clientToLoginMessageGroup.messages,
        clientToGateMessageGroup.messages,
        clientToRoomMessageGroup.messages,
        clientToHallMessageGroup.messages);
  }
}
