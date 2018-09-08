package com.funny.blood.modules.base.hall;


import io.netty.buffer.ByteBuf;
import shell.net.Message;
import shell.nio.ByteBufUtil;

import javax.annotation.Nullable;

import static shell.net.Message.NodeType.GATE;
import static shell.net.Message.NodeType.HALL;

/** 登录事件 */
public class GetHallRequest implements Message {
  public GetHallRequest() {}

  public GetHallRequest(int userID) {
    this.userID = userID;
  }

  /** 用户ID */
  private int userID;

  /** 用户ID */
  public GetHallRequest setUserID(int userID) {
    this.userID = userID;
    return this;
  }

  /** 用户ID */
  public int getUserID() {
    return this.userID;
  }

  @Override
  public void write(ByteBuf buf) {
    ByteBufUtil.writeInt(buf, this.userID);
  }

  @Override
  public GetHallRequest read(ByteBuf buf) {
    int size52413035;
    this.userID = ByteBufUtil.readInt(buf);
    return this;
  }

  @Override
  public String toString() {
    return "GetHallRequest{" +
           "userID='" + userID + '\'' +
           '}';
  }

  @Override
  public int id() {
    return 23;
  }

  @Override
  public NodeType from() {
    return GATE;
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
