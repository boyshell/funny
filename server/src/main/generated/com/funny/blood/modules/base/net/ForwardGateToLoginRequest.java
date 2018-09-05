package com.funny.blood.modules.base.net;


import io.netty.buffer.ByteBuf;
import shell.net.Message;
import shell.nio.ByteBufUtil;

import javax.annotation.Nullable;

import static shell.net.Message.NodeType.GATE;
import static shell.net.Message.NodeType.LOGIN;

/** 转发 */
public class ForwardGateToLoginRequest implements Message {
  public ForwardGateToLoginRequest() {}

  public ForwardGateToLoginRequest(String channelID, byte[] msg) {
    this.channelID = channelID;
    this.msg = msg;
  }

  /** channel id */
  private String channelID;
  /** 消息 */
  private byte[] msg;

  /** channel id */
  public ForwardGateToLoginRequest setChannelID(String channelID) {
    this.channelID = channelID;
    return this;
  }

  /** channel id */
  public String getChannelID() {
    return this.channelID;
  }

  /** 消息 */
  public ForwardGateToLoginRequest setMsg(byte[] msg) {
    this.msg = msg;
    return this;
  }

  /** 消息 */
  public byte[] getMsg() {
    return this.msg;
  }

  @Override
  public void write(ByteBuf buf) {
    ByteBufUtil.writeString(buf, this.channelID);
    ByteBufUtil.writeBytesWithLengthFlag(buf, this.msg);
  }

  @Override
  public ForwardGateToLoginRequest read(ByteBuf buf) {
    int size52413035;
    this.channelID = ByteBufUtil.readString(buf);
    this.msg = ByteBufUtil.readBytesWithLengthFlag(buf);
    return this;
  }

  @Override
  public int id() {
    return 12;
  }

  @Override
  public NodeType from() {
    return GATE;
  }

  @Override
  public NodeType to() {
    return LOGIN;
  }

  @Nullable
  public Message error(int e) {
    return null;
  }
}
