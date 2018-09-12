package com.funny.blood.modules.base.login;

import com.funny.blood.modules.base.net.KickType;
import com.funny.blood.modules.handler.LoginToGateHandler;
import com.funny.blood.server.gate.net.ClientToGateUser;
import com.funny.blood.server.gate.net.GateServer;
import com.funny.blood.server.gate.net.HallClient;
import com.funny.blood.utils.Null;
import com.google.inject.Inject;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetUserIDResponseHandler implements LoginToGateHandler<GetUserIDResponse> {
  private static final Logger logger =
      LoggerFactory.getLogger(GetUserIDResponseHandler.class);
  private final GateServer gateServer;
  private final HallClient hallClient;

  @Inject
  public GetUserIDResponseHandler(GateServer gateServer, HallClient hallClient) {
    this.gateServer = gateServer;
    this.hallClient = hallClient;
  }

  @Override
  public void exec(Channel channel, GetUserIDResponse message) {
    if (message.getError() != null) {
      logger.info("get user id error:{}", message);
      ClientToGateUser c = gateServer.getChannels().get(message.getChannelID());
      if (c != null) {
        LoginErrorLUT lut = LoginErrorLUT.valueOf(message.getError());
        if (lut != null) {
          c.closeAndWrite(lut.errMSG, lut.errStr);
        }
      }
      return;
    }
    logger.info("get user id suc:{}", message);
    ClientToGateUser oldUser = gateServer.getUser(message.getUserID());
    if (oldUser != null) { // 踢掉老玩家
      oldUser
          .getChannel()
          .eventLoop()
          .execute(
              () -> {
                oldUser.setUserID(Null.ID);
                oldUser.disconnect(KickType.REPLACE, "顶号");
              });
    }
    ClientToGateUser newUser = gateServer.getChannels().get(message.getChannelID());
    if (newUser == oldUser) {
      logger.error("what?{}", newUser.getUserID(), new IllegalArgumentException());
      return;
    }
    if (newUser == null) {
      logger.error("can not find user?{}", message.getChannelID(), new IllegalArgumentException());
      return;
    }
    newUser
        .getChannel()
        .eventLoop()
        .execute(
            () -> {
              gateServer.bind(newUser, message.getUserID());
              hallClient.write(new GetHallRequest(message.getUserID()));
            });
  }
}
