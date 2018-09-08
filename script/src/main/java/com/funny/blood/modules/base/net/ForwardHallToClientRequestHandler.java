package com.funny.blood.modules.base.net;

import com.funny.blood.modules.handler.HallToGateHandler;
import com.funny.blood.net.gate.ClientToGateUser;
import com.funny.blood.net.gate.GateServer;
import com.google.inject.Inject;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ForwardHallToClientRequestHandler
    implements HallToGateHandler<ForwardHallToClientRequest> {
  private static final Logger logger =
      LoggerFactory.getLogger(ForwardHallToClientRequestHandler.class);
  private final GateServer gateServer;

  @Inject
  public ForwardHallToClientRequestHandler(GateServer gateServer) {
    this.gateServer = gateServer;
  }

  @Override
  public void exec(Channel channel, ForwardHallToClientRequest message) {
    ClientToGateUser user = gateServer.getUser(message.getUserID());
    if (user == null) {
      logger.warn("user is null:{}", message.getUserID());
      return;
    }
    user.write(message.getMsg());
  }
}
