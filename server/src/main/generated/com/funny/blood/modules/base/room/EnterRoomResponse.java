package com.funny.blood.modules.base.room;


import io.netty.buffer.ByteBuf;
import shell.net.Message;
import shell.nio.ByteBufUtil;

import javax.annotation.Nullable;

import static shell.net.Message.NodeType.HALL;
import static shell.net.Message.NodeType.CLIENT;

/** 进入游戏 */
public class EnterRoomResponse implements Message {
  public EnterRoomResponse() {}

  public EnterRoomResponse(com.funny.blood.modules.base.room.GameType gameType, int roomID) {
    this.gameType = gameType;
    this.roomID = roomID;
  }

  /** 游戏类型[1:捕鱼] */
  private com.funny.blood.modules.base.room.GameType gameType;
  /** 房间编号 */
  private int roomID;

  /** 游戏类型[1:捕鱼] */
  public EnterRoomResponse setGameType(com.funny.blood.modules.base.room.GameType gameType) {
    this.gameType = gameType;
    return this;
  }

  /** 游戏类型[1:捕鱼] */
  public com.funny.blood.modules.base.room.GameType getGameType() {
    return this.gameType;
  }

  /** 房间编号 */
  public EnterRoomResponse setRoomID(int roomID) {
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
  public EnterRoomResponse read(ByteBuf buf) {
    int size52413035;
    this.gameType = com.funny.blood.modules.base.room.GameType.valueOf(ByteBufUtil.readInt(buf));
    this.roomID = ByteBufUtil.readInt(buf);
    return this;
  }

  @Override
  public String toString() {
    return "EnterRoomResponse{" +
           "gameType='" + gameType + '\'' +
           "roomID='" + roomID + '\'' +
           '}';
  }

  @Override
  public int id() {
    return 28;
  }

  @Override
  public NodeType from() {
    return HALL;
  }

  @Override
  public NodeType to() {
    return CLIENT;
  }

  @Nullable
  public Message error(int e) {
    return new EnterRoomError(e);
  }
}
