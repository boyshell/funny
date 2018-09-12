package com.funny.blood.modules.base.room;


import io.netty.buffer.ByteBuf;
import shell.net.Message;
import shell.nio.ByteBufUtil;

import javax.annotation.Nullable;

import static shell.net.Message.NodeType.CLIENT;
import static shell.net.Message.NodeType.HALL;

/** 进入游戏 */
public class EnterRoomRequest implements Message {
  public EnterRoomRequest() {}

  public EnterRoomRequest(com.funny.blood.modules.base.room.GameType gameType, int roomID) {
    this.gameType = gameType;
    this.roomID = roomID;
  }

  /** 游戏类型[1:捕鱼] */
  private com.funny.blood.modules.base.room.GameType gameType;
  /** 房间编号 */
  private int roomID;

  /** 游戏类型[1:捕鱼] */
  public EnterRoomRequest setGameType(com.funny.blood.modules.base.room.GameType gameType) {
    this.gameType = gameType;
    return this;
  }

  /** 游戏类型[1:捕鱼] */
  public com.funny.blood.modules.base.room.GameType getGameType() {
    return this.gameType;
  }

  /** 房间编号 */
  public EnterRoomRequest setRoomID(int roomID) {
    this.roomID = roomID;
    return this;
  }

  /** 房间编号 */
  public int getRoomID() {
    return this.roomID;
  }

  @Override
  public void write(ByteBuf buf) {
    ByteBufUtil.writeInt(buf, this.gameType != null ? this.gameType.getValue() : 0);
    ByteBufUtil.writeInt(buf, this.roomID);
  }

  @Override
  public EnterRoomRequest read(ByteBuf buf) {
    int size52413035;
    this.gameType = com.funny.blood.modules.base.room.GameType.valueOf(ByteBufUtil.readInt(buf));
    this.roomID = ByteBufUtil.readInt(buf);
    return this;
  }

  @Override
  public String toString() {
    return "EnterRoomRequest{" +
           "gameType='" + gameType + '\'' +
           "roomID='" + roomID + '\'' +
           '}';
  }

  @Override
  public int id() {
    return 27;
  }

  @Override
  public NodeType from() {
    return CLIENT;
  }

  @Override
  public NodeType to() {
    return HALL;
  }

  @Nullable
  public Message error(int e) {
    return new EnterRoomError(e);
  }
}
