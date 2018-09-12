package com.funny.blood.server.robot.net;

import com.funny.blood.net.CommonChannel;
import io.netty.channel.Channel;
import io.netty.util.AttributeKey;
import shell.net.NetUtil;

public class RobotUser extends CommonChannel {
  public static final AttributeKey<RobotUser> KEY = NetUtil.createAttributeKey(RobotUser.class);

  private final String username;

  public RobotUser(Channel channel, String username) {
    super(channel);
    this.username = username;
  }

  public String getUsername() {
    return username;
  }
}
