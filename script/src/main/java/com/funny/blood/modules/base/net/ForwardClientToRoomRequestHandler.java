package com.funny.blood.modules.base.net;

import com.funny.blood.modules.ClientToRoomMessageGroup;
import com.funny.blood.modules.handler.ClientToRoomHandler;
import com.funny.blood.modules.handler.GateToRoomHandler;
import com.funny.blood.modules.hg.ClientToRoomHandlerGroup;
import com.funny.blood.modules.user.room.UserInRoom;
import com.funny.blood.server.room.UserInRoomModule;
import com.funny.blood.server.room.worker.UserInRoomTask;
import com.google.inject.Inject;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shell.net.Message;

public class ForwardClientToRoomRequestHandler
    implements GateToRoomHandler<ForwardClientToRoomRequest> {
  private static final Logger logger =
      LoggerFactory.getLogger(ForwardClientToRoomRequestHandler.class);
  private final ClientToRoomMessageGroup messageGroup;
  private final ClientToRoomHandlerGroup handlerGroup;
  private final UserInRoomModule userInRoomModule;

  @Inject
  public ForwardClientToRoomRequestHandler(
      ClientToRoomMessageGroup messageGroup,
      ClientToRoomHandlerGroup handlerGroup,
      UserInRoomModule userInRoomModule) {
    this.messageGroup = messageGroup;
    this.handlerGroup = handlerGroup;
    this.userInRoomModule = userInRoomModule;
  }

  @Override
  public void exec(Channel channel, ForwardClientToRoomRequest message) {
    Message decode = Message.decode(message.getMsg(), messageGroup);
    if (decode == null) {
      logger.error("message is null:{}");
      return;
    }
    ClientToRoomHandler handler = handlerGroup.handler(decode.id());
    if (handler == null) {
      logger.error("handler is null:{}", decode);
      return;
    }
    userInRoomModule.exec(
        message.getUserID(),
        new UserInRoomTask("ForwardClientToRoomRequestHandler.exec") {
          @Override
          public void exec(UserInRoom user) {
            handler.exec(user, decode);
          }
        });
  }
}
