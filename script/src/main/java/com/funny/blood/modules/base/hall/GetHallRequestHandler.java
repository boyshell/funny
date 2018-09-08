package com.funny.blood.modules.base.hall;

import com.funny.blood.modules.base.room.GameBean;
import com.funny.blood.modules.base.room.GameType;
import com.funny.blood.modules.base.room.RoomBean;
import com.funny.blood.modules.base.user.hall.UserInHallModule;
import com.funny.blood.modules.handler.GateToHallHandler;
import com.funny.blood.net.hall.HallServer;
import com.funny.blood.net.hall.RoomToHallUser;
import com.google.inject.Inject;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shell.net.NetUtil;

import java.util.ArrayList;
import java.util.List;

public class GetHallRequestHandler implements GateToHallHandler<GetHallRequest> {
  private static final Logger logger = LoggerFactory.getLogger(GetHallRequestHandler.class);
  private final UserInHallModule userInHallModule;
  private final HallServer hallServer;

  @Inject
  public GetHallRequestHandler(UserInHallModule userInHallModule, HallServer hallServer) {
    this.userInHallModule = userInHallModule;
    this.hallServer = hallServer;
  }

  @Override
  public void exec(Channel channel, GetHallRequest message) {
    logger.info("rcv get hall msg:{}", message);
    userInHallModule.exec(
        message.getUserID(),
        user -> {
          user.setChannelAndThread(channel, Thread.currentThread());
          NetUtil.write(
              channel,
              new GetHallResponse(new HallBean(user.getId(), user.getValues().toList(), build())));
        });
  }

  private List<GameBean> build() {
    List<GameBean> list = new ArrayList<>(hallServer.getRooms().rowKeySet().size());
    for (GameType type : GameType.values()) {
      GameBean bean = new GameBean().setType(type);
      list.add(bean);
      for (RoomToHallUser user : hallServer.getRooms().row(type).values()) {
        bean.getRooms()
            .add(new RoomBean(user.getId(), user.getMax(), user.getNum(), user.getNeedChip()));
      }
    }
    return list;
  }
}
