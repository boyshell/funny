package com.funny.blood.modules.base.hall;

import com.funny.blood.modules.base.user.hall.UserInHallModule;
import com.funny.blood.modules.handler.GateToHallHandler;
import com.google.inject.Inject;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shell.net.NetUtil;

public class GetHallRequestHandler implements GateToHallHandler<GetHallRequest> {
  private static final Logger logger = LoggerFactory.getLogger(GetHallRequestHandler.class);
  private final UserInHallModule userInHallModule;

  @Inject
  public GetHallRequestHandler(UserInHallModule userInHallModule) {
    this.userInHallModule = userInHallModule;
  }

  @Override
  public void exec(Channel channel, GetHallRequest message) {
    logger.info("rcv get hall msg:{}", message);
    userInHallModule.exec(
        message.getUserID(),
        user -> {
          user.setChannelAndThread(channel, Thread.currentThread());
          NetUtil.write(
              channel, new GetHallResponse(new HallBean(user.getId(), user.getValues().toList())));
        });
  }
}
