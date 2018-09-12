package com.funny.blood.modules.base.room;


import io.netty.buffer.ByteBuf;
import shell.net.Message;
import shell.nio.ByteBufUtil;

import javax.annotation.Nullable;

import static shell.net.Message.NodeType.ROOM;
import static shell.net.Message.NodeType.HALL;

/** 添加用户 */
public class AddUserResponse implements Message {
  public AddUserResponse() {}

  public AddUserResponse(int userID, boolean suc) {
    this.userID = userID;
    this.suc = suc;
  }

  /** 用户ID */
  private int userID;
  /** 是否添加成功 */
  private boolean suc;

  /** 用户ID */
  public AddUserResponse setUserID(int userID) {
    this.userID = userID;
    return this;
  }

  /** 用户ID */
  public int getUserID() {
    return this.userID;
  }

  /** 是否添加成功 */
  public AddUserResponse setSuc(boolean suc) {
    this.suc = suc;
    return this;
  }

  /** 是否添加成功 */
  public boolean getSuc() {
    return this.suc;
  }

  @Override
  public void write(ByteBuf buf) {
    ByteBufUtil.writeInt(buf, this.userID);
    ByteBufUtil.writeBoolean(buf, this.suc);
  }

  @Override
  public AddUserResponse read(ByteBuf buf) {
    int size52413035;
    this.userID = ByteBufUtil.readInt(buf);
    this.suc = ByteBufUtil.readBoolean(buf);
    return this;
  }

  @Override
  public String toString() {
    return "AddUserResponse{" +
           "userID='" + userID + '\'' +
           "suc='" + suc + '\'' +
           '}';
  }

  @Override
  public int id() {
    return 31;
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
