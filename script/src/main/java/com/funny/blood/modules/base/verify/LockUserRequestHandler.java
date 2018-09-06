package com.funny.blood.modules.base.verify;

import com.funny.blood.modules.base.net.KickType;
import com.funny.blood.modules.handler.LoginToGateHandler;
import com.funny.blood.net.gate.ClientToGateUser;
import com.funny.blood.net.gate.GateServer;
import com.funny.blood.utils.Null;
import com.google.common.collect.BiMap;
import com.google.inject.Inject;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LockUserRequestHandler implements LoginToGateHandler<LockUserRequest> {
  private static final Logger logger = LoggerFactory.getLogger(LockUserRequestHandler.class);
  private final GateServer gateServer;

  @Inject
  public LockUserRequestHandler(GateServer gateServer) {
    this.gateServer = gateServer;
  }

  @Override
  public void exec(Channel channel, LockUserRequest message) {
    BiMap<Integer, String> inverse = gateServer.getChannelID2userID().inverse();
    String channelID = inverse.get(message.getUserID());
    if (channelID != null) {
      ClientToGateUser netUser = gateServer.getChannels().get(channelID);
      if (netUser != null) {
        netUser
            .getChannel()
            .eventLoop()
            .execute(
                () -> {
                  netUser.setUserID(Null.ID);
                  netUser.disconnect(KickType.REPLACE, "顶号");
                });
      }
    }
    ClientToGateUser netUser = gateServer.getChannels().get(message.getChannelID());
    if (netUser == null) {
      return;
    }
    netUser.getChannel().eventLoop().execute(() -> netUser.setUserID(message.getUserID()));
  }
}
