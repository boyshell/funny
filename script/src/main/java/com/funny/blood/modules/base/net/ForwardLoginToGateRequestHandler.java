package com.funny.blood.modules.base.net;

import com.funny.blood.modules.handler.LoginToGateHandler;
import com.funny.blood.net.gate.ClientToGateUser;
import com.funny.blood.net.gate.GateServer;
import com.google.inject.Inject;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shell.lang.StringUtil;

public class ForwardLoginToGateRequestHandler
    implements LoginToGateHandler<ForwardLoginToGateRequest> {
  private static final Logger logger =
      LoggerFactory.getLogger(ForwardLoginToGateRequestHandler.class);
  private final GateServer gateServer;

  @Inject
  public ForwardLoginToGateRequestHandler(GateServer gateServer) {
    this.gateServer = gateServer;
  }


  @Override
  public void exec(Channel channel, ForwardLoginToGateRequest message) {
    ClientToGateUser netUser = gateServer.getChannels().get(message.getChannelID());
    if (netUser == null) {
      logger.error("net user is null:{}", message.getChannelID());
      return;
    }
    if (StringUtil.isNullOrEmpty(message.getCloseReason())) {
      netUser.write(message.getMsg());
    } else {
      netUser.closeAndWrite(message.getMsg(), message.getCloseReason());
    }
  }
}
