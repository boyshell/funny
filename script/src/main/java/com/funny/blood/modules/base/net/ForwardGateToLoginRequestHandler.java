package com.funny.blood.modules.base.net;

import com.funny.blood.modules.ClientToLoginMessageGroup;
import com.funny.blood.modules.base.user.UserModule;
import com.funny.blood.modules.handler.GateToLoginHandler;
import com.funny.blood.modules.hg.ClientToLoginHandlerGroup;
import com.funny.blood.modules.user.login.User;
import com.funny.blood.net.login.ClientToLoginUser;
import com.funny.blood.net.login.GateToLoginUser;
import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shell.net.Message;
import shell.util.concurrent.AbstractNamedRunnable;

public class ForwardGateToLoginRequestHandler
    implements GateToLoginHandler<ForwardGateToLoginRequest> {
  private static final Logger logger =
      LoggerFactory.getLogger(ForwardGateToLoginRequestHandler.class);
  private final UserModule userModule;
  private final ClientToLoginMessageGroup messageGroup;
  private final ClientToLoginHandlerGroup handlerGroup;

  @Inject
  public ForwardGateToLoginRequestHandler(
      UserModule userModule,
      ClientToLoginMessageGroup messageGroup,
      ClientToLoginHandlerGroup handlerGroup) {
    this.userModule = userModule;
    this.messageGroup = messageGroup;
    this.handlerGroup = handlerGroup;
  }

  @Override
  public void exec(GateToLoginUser netUser, ForwardGateToLoginRequest message) {
    ClientToLoginUser clientUser = netUser.getClientUsers().get(message.getChannelID());
    if (clientUser == null) {
      logger.error("client is null:{}", message.getChannelID());
      return;
    }

    User user = clientUser.getUserRef().get();
    if (user == null) {
      logger.error("user is null:{}", message.getChannelID());
      return;
    }

    if (!user.getClientDoor().isOpenForMe(clientUser)) {
      logger.error("door is not open for me:{}", message.getChannelID());
      return;
    }
    user.getUser()
        .executor()
        .execute(
            new AbstractNamedRunnable("ForwardGateToLoginRequestHandler.exec") {
              @Override
              public void run() {
                Message decode = Message.decode(message.getMsg(), messageGroup);
                if (decode == null) {
                  logger.error("forward error msg");
                  return;
                }
                handlerGroup.handler(decode.id()).exec(user, decode);
              }
            });
  }
}
