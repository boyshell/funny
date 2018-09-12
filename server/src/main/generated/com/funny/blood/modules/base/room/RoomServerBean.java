package com.funny.blood.modules.base.room;

import io.netty.buffer.ByteBuf;
import shell.net.Bean;
import shell.nio.ByteBufUtil;

/** 房间服务器 */
public class RoomServerBean implements Bean<RoomServerBean> {
  public RoomServerBean() {}

  public RoomServerBean(com.funny.blood.modules.base.room.GameType gameType, int roomID, String host, int port) {
    this.gameType = gameType;
    this.roomID = roomID;
    this.host = host;
    this.port = port;
  }

  /** 游戏类型[1:捕鱼] */
  private com.funny.blood.modules.base.room.GameType gameType;
  /** 房间编号 */
  private int roomID;
  /** 主机地址 */
  private String host;
  /** 主机端口 */
  private int port;

  /** 游戏类型[1:捕鱼] */
  public RoomServerBean setGameType(com.funny.blood.modules.base.room.GameType gameType) {
    this.gameType = gameType;
    return this;
  }

  /** 游戏类型[1:捕鱼] */
  public com.funny.blood.modules.base.room.GameType getGameType() {
    return this.gameType;
  }

  /** 房间编号 */
  public RoomServerBean setRoomID(int roomID) {
    this.roomID = roomID;
    return this;
  }

  /** 房间编号 */
  public int getRoomID() {
    return this.roomID;
  }

  /** 主机地址 */
  public RoomServerBean setHost(String host) {
    this.host = host;
    return this;
  }

  /** 主机地址 */
  public String getHost() {
    return this.host;
  }

  /** 主机端口 */
  public RoomServerBean setPort(int port) {
    this.port = port;
    return this;
  }

  /** 主机端口 */
  public int getPort() {
    return this.port;
  }

  @Override
  public void write(ByteBuf buf) {
    ByteBufUtil.writeInt(buf, this.gameType != null ? this.gameType.getValue() : 0);
    ByteBufUtil.writeInt(buf, this.roomID);
    ByteBufUtil.writeString(buf, this.host);
    ByteBufUtil.writeInt(buf, this.port);
  }

  @Override
  public RoomServerBean read(ByteBuf buf) {
    int size52413035;
    this.gameType = com.funny.blood.modules.base.room.GameType.valueOf(ByteBufUtil.readInt(buf));
    this.roomID = ByteBufUtil.readInt(buf);
    this.host = ByteBufUtil.readString(buf);
    this.port = ByteBufUtil.readInt(buf);
    return this;
  }

  @Override
  public String toString() {
    return "RoomServerBean{" +
           "gameType='" + gameType + '\'' +
           "roomID='" + roomID + '\'' +
           "host='" + host + '\'' +
           "port='" + port + '\'' +
           '}';
  }
}