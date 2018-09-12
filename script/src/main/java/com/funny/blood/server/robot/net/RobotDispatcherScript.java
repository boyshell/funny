package com.funny.blood.server.robot.net;

import com.funny.blood.cfg.ConfigDataSet;
import com.funny.blood.modules.MessageVersion;
import com.funny.blood.modules.base.login.VersionCheckRequest;
import com.funny.blood.net.IDispatcherScript;
import com.funny.blood.server.robot.RobotProperties;
import com.google.inject.Inject;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shell.net.Message;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class RobotDispatcherScript implements IDispatcherScript {
  private static final Logger logger = LoggerFactory.getLogger(RobotDispatcherScript.class);
  private final RobotHandlerGroup handlerGroup;
  private final AtomicInteger seed = new AtomicInteger();
  private final RobotProperties properties;
  private final ConfigDataSet configDataSet;

  @Inject
  public RobotDispatcherScript(
      RobotHandlerGroup handlerGroup, RobotProperties properties, ConfigDataSet configDataSet) {
    this.handlerGroup = handlerGroup;
    this.properties = properties;
    this.configDataSet = configDataSet;
  }

  @Override
  public void tick(Channel channel, long now) {
    // todo
  }

  @Override
  public void onChannelActive(Channel channel) {
    // 这里不要即时发送消息
    RobotUser user = new RobotUser(channel, properties.ROBOT_NAME + seed.incrementAndGet());
    channel.attr(RobotUser.KEY).set(user);

    channel
        .eventLoop()
        .schedule(
            () -> {
              user.write(
                  new VersionCheckRequest(
                      MessageVersion.VERSION, configDataSet.getConfigGroup().CODE_VERSION));
            },
            1,
            TimeUnit.SECONDS);
  }

  @Override
  public void onChannelInactive(Channel channel) {
    channel.attr(RobotUser.KEY).remove();
  }

  @Override
  public void onChannelRead(Channel channel, Message message) {
    IRobotHandler handler = handlerGroup.handler(message.id());
    if (handler == null) {
      logger.error("handler is null:{}", message);
      return;
    }
    handler.exec(channel.attr(RobotUser.KEY).get(), message);
  }
}
