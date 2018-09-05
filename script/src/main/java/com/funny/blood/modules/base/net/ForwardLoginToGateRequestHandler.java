package com.funny.blood.modules.base.net;

import com.funny.blood.modules.handler.LoginToGateHandler;
import com.funny.blood.net.gate.ClientToGateDispatcher;
import com.funny.blood.net.gate.ClientToGateUser;
import com.google.inject.Inject;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shell.lang.StringUtil;

public class ForwardLoginToGateRequestHandler
    implements LoginToGateHandler<ForwardLoginToGateRequest> {
  private static final Logger logger =
      LoggerFactory.getLogger(ForwardLoginToGateRequestHandler.class);
  private final ClientToGateDispatcher clientToGateDispatcher;

  @Inject
  public ForwardLoginToGateRequestHandler(ClientToGateDispatcher clientToGateDispatcher) {
    this.clientToGateDispatcher = clientToGateDispatcher;
  }

  @Override
  public void exec(Channel channel, ForwardLoginToGateRequest message) {
    ClientToGateUser netUser = clientToGateDispatcher.getChannels().get(message.getChannelID());
    if (netUser == null) {
      logger.error("net user is null:{}", message.getChannelID());
      return;
    }
    if (StringUtil.isNullOrEmpty(message.getCloseReason())) {
      netUser.closeAndWrite(message.getMsg(), message.getCloseReason());
    } else {
      netUser.write(message.getMsg());
    }
  }
}
