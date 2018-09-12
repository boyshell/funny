package com.funny.blood.modules.base.room;


import io.netty.buffer.ByteBuf;
import shell.net.Message;
import shell.nio.ByteBufUtil;

import javax.annotation.Nullable;

import static shell.net.Message.NodeType.HALL;
import static shell.net.Message.NodeType.GATE;

/** 移除房间 */
public class RemoveRoomRequest implements Message {
  public RemoveRoomRequest() {}

  public RemoveRoomRequest(com.funny.blood.modules.base.room.GameType gameType, int roomID) {
    this.gameType = gameType;
    this.roomID = roomID;
  }

  /** 房间服务器[1:捕鱼] */
  private com.funny.blood.modules.base.room.GameType gameType;
  /** 房间ID */
  private int roomID;

  /** 房间服务器[1:捕鱼] */
  public RemoveRoomRequest setGameType(com.funny.blood.modules.base.room.GameType gameType) {
    this.gameType = gameType;
    return this;
  }

  /** 房间服务器[1:捕鱼] */
  public com.funny.blood.modules.base.room.GameType getGameType() {
    return this.gameType;
  }

  /** 房间ID */
  public RemoveRoomRequest setRoomID(int roomID) {
    this.roomID = roomID;
    return this;
  }

  /** 房间ID */
  public int getRoomID() {
    return this.roomID;
  }

  @Override
  public void write(ByteBuf buf) {
    ByteBufUtil.writeInt(buf, this.gameType != null ? this.gameType.getValue() : 0);
    ByteBufUtil.writeInt(buf, this.roomID);
  }

  @Override
  public RemoveRoomRequest read(ByteBuf buf) {
    int size52413035;
    this.gameType = com.funny.blood.modules.base.room.GameType.valueOf(ByteBufUtil.readInt(buf));
    this.roomID = ByteBufUtil.readInt(buf);
    return this;
  }

  @Override
  public String toString() {
    return "RemoveRoomRequest{" +
           "gameType='" + gameType + '\'' +
           "roomID='" + roomID + '\'' +
           '}';
  }

  @Override
  public int id() {
    return 35;
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
