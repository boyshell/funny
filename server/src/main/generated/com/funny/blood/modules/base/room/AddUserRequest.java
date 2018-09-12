package com.funny.blood.modules.base.room;


import io.netty.buffer.ByteBuf;
import shell.net.Message;
import shell.nio.ByteBufUtil;

import javax.annotation.Nullable;

import static shell.net.Message.NodeType.HALL;
import static shell.net.Message.NodeType.ROOM;

/** 添加用户 */
public class AddUserRequest implements Message {
  public AddUserRequest() {}

  public AddUserRequest(int userID) {
    this.userID = userID;
  }

  /** 用户ID */
  private int userID;

  /** 用户ID */
  public AddUserRequest setUserID(int userID) {
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
  public AddUserRequest read(ByteBuf buf) {
    int size52413035;
    this.userID = ByteBufUtil.readInt(buf);
    return this;
  }

  @Override
  public String toString() {
    return "AddUserRequest{" +
           "userID='" + userID + '\'' +
           '}';
  }

  @Override
  public int id() {
    return 30;
  }

  @Override
  public NodeType from() {
    return HALL;
  }

  @Override
  public NodeType to() {
    return ROOM;
  }

  @Nullable
  public Message error(int e) {
    return null;
  }
}
