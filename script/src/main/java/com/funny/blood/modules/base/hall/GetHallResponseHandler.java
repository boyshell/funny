package com.funny.blood.modules.base.hall;

import com.funny.blood.modules.base.verify.LoginResponse;
import com.funny.blood.modules.handler.HallToGateHandler;
import com.funny.blood.net.gate.ClientToGateUser;
import com.funny.blood.net.gate.GateServer;
import com.google.inject.Inject;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetHallResponseHandler implements HallToGateHandler<GetHallResponse> {
  private static final Logger logger = LoggerFactory.getLogger(GetHallResponseHandler.class);
  private final GateServer gateServer;

  @Inject
  public GetHallResponseHandler(GateServer gateServer) {
    this.gateServer = gateServer;
  }

  @Override
  public void exec(Channel channel, GetHallResponse message) {
    logger.info("get hall suc:{}", message);
    ClientToGateUser user = gateServer.getUser(message.getHall().getUserID());
    if (user == null) {
      logger.warn("user is null:{}", message.getHall().getUserID(), new NullPointerException());
      return;
    }
    user.write(new LoginResponse(message.getHall()));
  }
}
