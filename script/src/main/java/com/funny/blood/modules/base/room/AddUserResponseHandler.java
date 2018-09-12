package com.funny.blood.modules.base.room;

import com.funny.blood.modules.handler.RoomToHallHandler;
import com.funny.blood.modules.user.hall.UserInHall;
import com.funny.blood.server.hall.UserInHallModule;
import com.funny.blood.server.hall.net.RoomToHallUser;
import com.funny.blood.server.hall.worker.UserInHallTask;
import com.google.inject.Inject;
import io.netty.channel.Channel;
import shell.net.NetUtil;

import java.lang.ref.WeakReference;

public class AddUserResponseHandler implements RoomToHallHandler<AddUserResponse> {
  private final UserInHallModule userInHallModule;

  @Inject
  public AddUserResponseHandler(UserInHallModule userInHallModule) {
    this.userInHallModule = userInHallModule;
  }

  @Override
  public void exec(Channel channel, AddUserResponse message) {
    if (!message.getSuc()) {
      error(message.getUserID(), EnterRoomError.FULL);
      return;
    }
    RoomToHallUser netUser = channel.attr(RoomToHallUser.KEY).get();
    if (netUser == null) {
      error(message.getUserID(), EnterRoomError.SYS);
      return;
    }
    netUser.setNum(netUser.getNum() + 1);
    userInHallModule.exec(
        message.getUserID(),
        new UserInHallTask("AddUserResponseHandler.exec") {
          @Override
          public void exec0(UserInHall user) {
            user.setRoomRef(new WeakReference<>(netUser));
            NetUtil.write(
                user.getChannel(),
                new BindRoomRequest(message.getUserID(), netUser.getType(), netUser.getId()));
          }
        });
  }

  private void error(int userID, byte[] error) {
    userInHallModule.exec(
        userID,
        new UserInHallTask("AddUserResponseHandler.error") {
          @Override
          public void exec0(UserInHall user) {
            user.write(error);
          }
        });
  }
}
