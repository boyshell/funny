package com.funny.blood.modules.base.room;


import io.netty.buffer.ByteBuf;
import shell.net.Message;
import shell.nio.ByteBufUtil;

import javax.annotation.Nullable;

import static shell.net.Message.NodeType.HALL;
import static shell.net.Message.NodeType.GATE;

/** 绑定房间服务器 */
public class BindRoomRequest implements Message {
  public BindRoomRequest() {}

  public BindRoomRequest(int userID, com.funny.blood.modules.base.room.GameType gameType, int roomID) {
    this.userID = userID;
    this.gameType = gameType;
    this.roomID = roomID;
  }

  /** 用户ID */
  private int userID;
  /** 游戏类型[1:捕鱼] */
  private com.funny.blood.modules.base.room.GameType gameType;
  /** 房间编号 */
  private int roomID;

  /** 用户ID */
  public BindRoomRequest setUserID(int userID) {
    this.userID = userID;
    return this;
  }

  /** 用户ID */
  public int getUserID() {
    return this.userID;
  }

  /** 游戏类型[1:捕鱼] */
  public BindRoomRequest setGameType(com.funny.blood.modules.base.room.GameType gameType) {
    this.gameType = gameType;
    return this;
  }

  /** 游戏类型[1:捕鱼] */
  public com.funny.blood.modules.base.room.GameType getGameType() {
    return this.gameType;
  }

  /** 房间编号 */
  public BindRoomRequest setRoomID(int roomID) {
    this.roomID = roomID;
    return this;
  }

  /** 房间编号 */
  public int getRoomID() {
    return this.roomID;
  }

  @Override
  public void write(ByteBuf buf) {
    ByteBufUtil.writeInt(buf, this.userID);
    ByteBufUtil.writeInt(buf, this.gameType != null ? this.gameType.getValue() : 0);
    ByteBufUtil.writeInt(buf, this.roomID);
  }

  @Override
  public BindRoomRequest read(ByteBuf buf) {
    int size52413035;
    this.userID = ByteBufUtil.readInt(buf);
    this.gameType = com.funny.blood.modules.base.room.GameType.valueOf(ByteBufUtil.readInt(buf));
    this.roomID = ByteBufUtil.readInt(buf);
    return this;
  }

  @Override
  public String toString() {
    return "BindRoomRequest{" +
           "userID='" + userID + '\'' +
           "gameType='" + gameType + '\'' +
           "roomID='" + roomID + '\'' +
           '}';
  }

  @Override
  public int id() {
    return 36;
  }

  @Override
  public NodeType from() {
    return HALL;
  }

  @Override
  public NodeType to() {
    return GATE;
  }

  @Nullable
  public Message error(int e) {
    return null;
  }
}
