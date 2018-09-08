package com.funny.blood.net.room;

import com.funny.blood.modules.base.room.RegisterRoomToHallRequest;
import com.funny.blood.modules.handler.HallToRoomHandler;
import com.funny.blood.modules.hg.HallToRoomHandlerGroup;
import com.funny.blood.net.IDispatcherScript;
import com.funny.blood.properties.RoomProperties;
import com.google.inject.Inject;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shell.net.Message;
import shell.net.NetUtil;

public class HallToRoomDispatcherScript implements IDispatcherScript {
  private static final Logger logger = LoggerFactory.getLogger(HallToRoomDispatcherScript.class);
  private final HallToRoomHandlerGroup handlerGroup;
  private final RoomProperties properties;

  @Inject
  public HallToRoomDispatcherScript(
      HallToRoomHandlerGroup handlerGroup, RoomProperties properties) {
    this.handlerGroup = handlerGroup;
    this.properties = properties;
  }

  @Override
  public void tick(Channel channel, long now) {
    // todo
  }

  @Override
  public void onChannelActive(Channel channel) {
    NetUtil.write(
        channel,
        new RegisterRoomToHallRequest(
            properties.GAME_TYPE,
            properties.ID,
            properties.HOST,
            properties.PORT,
            properties.MAX,
            properties.NEED_CHIP));
  }

  @Override
  public void onChannelInactive(Channel channel) {
    // todo
  }

  @Override
  public void onChannelRead(Channel channel, Message message) {
    HallToRoomHandler handler = handlerGroup.handler(message.id());
    if (handler == null) {
      logger.error("handler is null:{}", message);
      return;
    }
    handler.exec(channel, message);
  }
}
