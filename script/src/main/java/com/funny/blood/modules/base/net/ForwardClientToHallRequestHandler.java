package com.funny.blood.modules.base.net;

import com.funny.blood.modules.ClientToHallMessageGroup;
import com.funny.blood.modules.handler.ClientToHallHandler;
import com.funny.blood.modules.handler.GateToHallHandler;
import com.funny.blood.modules.hg.ClientToHallHandlerGroup;
import com.funny.blood.modules.user.hall.UserInHall;
import com.funny.blood.server.hall.UserInHallModule;
import com.funny.blood.server.hall.worker.UserInHallTask;
import com.google.inject.Inject;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shell.net.Message;

public class ForwardClientToHallRequestHandler
    implements GateToHallHandler<ForwardClientToHallRequest> {
  private static final Logger logger =
      LoggerFactory.getLogger(ForwardClientToHallRequestHandler.class);
  private final ClientToHallHandlerGroup hallHandlerGroup;
  private final ClientToHallMessageGroup messageGroup;
  private final UserInHallModule userInHallModule;

  @Inject
  public ForwardClientToHallRequestHandler(
      ClientToHallHandlerGroup hallHandlerGroup,
      ClientToHallMessageGroup messageGroup,
      UserInHallModule userInHallModule) {
    this.hallHandlerGroup = hallHandlerGroup;
    this.messageGroup = messageGroup;
    this.userInHallModule = userInHallModule;
  }

  @Override
  public void exec(Channel channel, ForwardClientToHallRequest message) {
    Message decode = Message.decode(message.getMsg(), messageGroup);
    if (decode == null) {
      logger.error("decode error:{}", message.getUserID(), new IllegalArgumentException());
      return;
    }
    ClientToHallHandler handler = hallHandlerGroup.handler(decode.id());
    if (handler == null) {
      logger.error("handler is null:{}", message, new NullPointerException());
      return;
    }
    // todo 可优化，产生尽可能少的对象
    userInHallModule.exec(
        message.getUserID(),
        new UserInHallTask("ForwardClientToHallRequestHandler.exec") {
          @Override
          public void exec0(UserInHall user) {
            handler.exec(user, decode);
          }
        });
  }
}
