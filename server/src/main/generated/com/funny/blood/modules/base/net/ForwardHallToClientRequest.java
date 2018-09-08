package com.funny.blood.modules.base.net;


import io.netty.buffer.ByteBuf;
import shell.net.Message;
import shell.nio.ByteBufUtil;

import javax.annotation.Nullable;

import static shell.net.Message.NodeType.HALL;
import static shell.net.Message.NodeType.GATE;

/** 转发 */
public class ForwardHallToClientRequest implements Message {
  public ForwardHallToClientRequest() {}

  public ForwardHallToClientRequest(int userID, byte[] msg) {
    this.userID = userID;
    this.msg = msg;
  }

  /** 用户ID */
  private int userID;
  /** 消息 */
  private byte[] msg;

  /** 用户ID */
  public ForwardHallToClientRequest setUserID(int userID) {
    this.userID = userID;
    return this;
  }

  /** 用户ID */
  public int getUserID() {
    return this.userID;
  }

  /** 消息 */
  public ForwardHallToClientRequest setMsg(byte[] msg) {
    this.msg = msg;
    return this;
  }

  /** 消息 */
  public byte[] getMsg() {
    return this.msg;
  }

  @Override
  public void write(ByteBuf buf) {
    ByteBufUtil.writeInt(buf, this.userID);
    ByteBufUtil.writeBytesWithLengthFlag(buf, this.msg);
  }

  @Override
  public ForwardHallToClientRequest read(ByteBuf buf) {
    int size52413035;
    this.userID = ByteBufUtil.readInt(buf);
    this.msg = ByteBufUtil.readBytesWithLengthFlag(buf);
    return this;
  }

  @Override
  public String toString() {
    return "ForwardHallToClientRequest{" +
           "userID='" + userID + '\'' +
           "msg='" + msg + '\'' +
           '}';
  }

  @Override
  public int id() {
    return 22;
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
