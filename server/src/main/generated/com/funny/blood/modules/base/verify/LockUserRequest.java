package com.funny.blood.modules.base.verify;


import io.netty.buffer.ByteBuf;
import shell.net.Message;
import shell.nio.ByteBufUtil;

import javax.annotation.Nullable;

import static shell.net.Message.NodeType.LOGIN;
import static shell.net.Message.NodeType.GATE;

/** 绑定channel和账号 */
public class LockUserRequest implements Message {
  public LockUserRequest() {}

  public LockUserRequest(String channelID, int userID) {
    this.channelID = channelID;
    this.userID = userID;
  }

  /** channel id */
  private String channelID;
  /** 用户ID */
  private int userID;

  /** channel id */
  public LockUserRequest setChannelID(String channelID) {
    this.channelID = channelID;
    return this;
  }

  /** channel id */
  public String getChannelID() {
    return this.channelID;
  }

  /** 用户ID */
  public LockUserRequest setUserID(int userID) {
    this.userID = userID;
    return this;
  }

  /** 用户ID */
  public int getUserID() {
    return this.userID;
  }

  @Override
  public void write(ByteBuf buf) {
    ByteBufUtil.writeString(buf, this.channelID);
    ByteBufUtil.writeInt(buf, this.userID);
  }

  @Override
  public LockUserRequest read(ByteBuf buf) {
    int size52413035;
    this.channelID = ByteBufUtil.readString(buf);
    this.userID = ByteBufUtil.readInt(buf);
    return this;
  }

  @Override
  public int id() {
    return 19;
  }

  @Override
  public NodeType from() {
    return LOGIN;
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
