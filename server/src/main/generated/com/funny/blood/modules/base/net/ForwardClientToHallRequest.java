package com.funny.blood.modules.base.net;


import io.netty.buffer.ByteBuf;
import shell.net.Message;
import shell.nio.ByteBufUtil;

import javax.annotation.Nullable;

import static shell.net.Message.NodeType.GATE;
import static shell.net.Message.NodeType.HALL;

/** 转发 */
public class ForwardClientToHallRequest implements Message {
  public ForwardClientToHallRequest() {}

  public ForwardClientToHallRequest(int userID, byte[] msg) {
    this.userID = userID;
    this.msg = msg;
  }

  /** 用户ID */
  private int userID;
  /** 消息 */
  private byte[] msg;

  /** 用户ID */
  public ForwardClientToHallRequest setUserID(int userID) {
    this.userID = userID;
    return this;
  }

  /** 用户ID */
  public int getUserID() {
    return this.userID;
  }

  /** 消息 */
  public ForwardClientToHallRequest setMsg(byte[] msg) {
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
  public ForwardClientToHallRequest read(ByteBuf buf) {
    int size52413035;
    this.userID = ByteBufUtil.readInt(buf);
    this.msg = ByteBufUtil.readBytesWithLengthFlag(buf);
    return this;
  }

  @Override
  public String toString() {
    return "ForwardClientToHallRequest{" +
           "userID='" + userID + '\'' +
           "msg='" + msg + '\'' +
           '}';
  }

  @Override
  public int id() {
    return 11;
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
