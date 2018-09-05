package com.funny.blood.modules.base.net;

import com.funny.blood.modules.handler.GateToLoginHandler;
import com.funny.blood.net.login.GateToLoginUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RemoveClientUserInLoginRequestHandler
    implements GateToLoginHandler<RemoveClientUserInLoginRequest> {
  private static final Logger logger =
      LoggerFactory.getLogger(RemoveClientUserInLoginRequestHandler.class);

  @Override
  public void exec(GateToLoginUser netUser, RemoveClientUserInLoginRequest message) {
    if (netUser.getClientUsers().remove(message.getChannelID()) == null) {
      logger.error("remove error:{}", message);
    } else {
      logger.info("add:{}", message);
    }
  }
}
