package com.funny.blood.net.gate;

import com.funny.blood.modules.base.net.ForwardGateToHallRequest;
import com.funny.blood.net.CommonChannel;
import com.google.inject.Inject;
import shell.net.Message;

public class HallClient extends CommonChannel {
  @Inject
  public HallClient() {
    super(null);
  }

  public boolean forward(String channelID, Message message) {
    return write(new ForwardGateToHallRequest(channelID, Message.encodeToBytes(message)));
  }
}
