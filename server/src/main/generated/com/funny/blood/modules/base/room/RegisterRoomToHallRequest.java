package com.funny.blood.modules.base.room;


import io.netty.buffer.ByteBuf;
import shell.net.Message;
import shell.nio.ByteBufUtil;

import javax.annotation.Nullable;

import static shell.net.Message.NodeType.ROOM;
import static shell.net.Message.NodeType.HALL;

/** 注册房间 */
public class RegisterRoomToHallRequest implements Message {
  public RegisterRoomToHallRequest() {}

  public RegisterRoomToHallRequest(com.funny.blood.modules.base.room.GameType type, int id, String host, int port, int max, int needChip) {
    this.type = type;
    this.id = id;
    this.host = host;
    this.port = port;
    this.max = max;
    this.needChip = needChip;
  }

  /** 游戏类型[1:捕鱼] */
  private com.funny.blood.modules.base.room.GameType type;
  /** 房间ID */
  private int id;
  /** 主机地址 */
  private String host;
  /** 端口 */
  private int port;
  /** 人数上限 */
  private int max;
  /** 需要的筹码数量 */
  private int needChip;

  /** 游戏类型[1:捕鱼] */
  public RegisterRoomToHallRequest setType(com.funny.blood.modules.base.room.GameType type) {
    this.type = type;
    return this;
  }

  /** 游戏类型[1:捕鱼] */
  public com.funny.blood.modules.base.room.GameType getType() {
    return this.type;
  }

  /** 房间ID */
  public RegisterRoomToHallRequest setId(int id) {
    this.id = id;
    return this;
  }

  /** 房间ID */
  public int getId() {
    return this.id;
  }

  /** 主机地址 */
  public RegisterRoomToHallRequest setHost(String host) {
    this.host = host;
    return this;
  }

  /** 主机地址 */
  public String getHost() {
    return this.host;
  }

  /** 端口 */
  public RegisterRoomToHallRequest setPort(int port) {
    this.port = port;
    return this;
  }

  /** 端口 */
  public int getPort() {
    return this.port;
  }

  /** 人数上限 */
  public RegisterRoomToHallRequest setMax(int max) {
    this.max = max;
    return this;
  }

  /** 人数上限 */
  public int getMax() {
    return this.max;
  }

  /** 需要的筹码数量 */
  public RegisterRoomToHallRequest setNeedChip(int needChip) {
    this.needChip = needChip;
    return this;
  }

  /** 需要的筹码数量 */
  public int getNeedChip() {
    return this.needChip;
  }

  @Override
  public void write(ByteBuf buf) {
    ByteBufUtil.writeInt(buf, this.type != null ? this.type.getValue() : 0);
    ByteBufUtil.writeInt(buf, this.id);
    ByteBufUtil.writeString(buf, this.host);
    ByteBufUtil.writeInt(buf, this.port);
    ByteBufUtil.writeInt(buf, this.max);
    ByteBufUtil.writeInt(buf, this.needChip);
  }

  @Override
  public RegisterRoomToHallRequest read(ByteBuf buf) {
    int size52413035;
    this.type = com.funny.blood.modules.base.room.GameType.valueOf(ByteBufUtil.readInt(buf));
    this.id = ByteBufUtil.readInt(buf);
    this.host = ByteBufUtil.readString(buf);
    this.port = ByteBufUtil.readInt(buf);
    this.max = ByteBufUtil.readInt(buf);
    this.needChip = ByteBufUtil.readInt(buf);
    return this;
  }

  @Override
  public String toString() {
    return "RegisterRoomToHallRequest{" +
           "type='" + type + '\'' +
           "id='" + id + '\'' +
           "host='" + host + '\'' +
           "port='" + port + '\'' +
           "max='" + max + '\'' +
           "needChip='" + needChip + '\'' +
           '}';
  }

  @Override
  public int id() {
    return 26;
  }

  @Override
  public NodeType from() {
    return ROOM;
  }

  @Override
  public NodeType to() {
    return HALL;
  }

  @Nullable
  public Message error(int e) {
    return null;
  }
}
