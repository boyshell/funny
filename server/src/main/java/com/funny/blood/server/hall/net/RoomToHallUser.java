package com.funny.blood.server.hall.net;

import com.funny.blood.modules.base.room.GameType;
import com.funny.blood.net.CommonChannel;
import io.netty.channel.Channel;
import io.netty.util.AttributeKey;
import shell.net.NetUtil;

public class RoomToHallUser extends CommonChannel {
  public static final AttributeKey<RoomToHallUser> KEY =
      NetUtil.createAttributeKey(RoomToHallUser.class);

  private final GameType type;
  private final int id;
  private final String host;
  private final int port;
  private final int max;
  private final int needChip;
  private volatile int num;

  public RoomToHallUser(
      Channel channel, GameType type, int id, String host, int port, int max, int needChip) {
    super(channel);
    this.type = type;
    this.id = id;
    this.host = host;
    this.port = port;
    this.max = max;
    this.needChip = needChip;
  }

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

  public GameType getType() {
    return type;
  }

  public int getId() {
    return id;
  }

  public String getHost() {
    return host;
  }

  public int getPort() {
    return port;
  }

  public int getMax() {
    return max;
  }

  public int getNeedChip() {
    return needChip;
  }
}
