package com.funny.blood.modules.base.net;


import io.netty.buffer.ByteBuf;
import shell.net.Message;
import shell.nio.ByteBufUtil;

import javax.annotation.Nullable;

import static shell.net.Message.NodeType.LOGIN;
import static shell.net.Message.NodeType.GATE;

/** 转发 */
public class ForwardLoginToGateRequest implements Message {
  public ForwardLoginToGateRequest() {}

  public ForwardLoginToGateRequest(String channelID, String closeReason, byte[] msg) {
    this.channelID = channelID;
    this.closeReason = closeReason;
    this.msg = msg;
  }

  /** channel id */
  private String channelID;
  /** 关闭channel的原因，没有则不关闭 */
  private String closeReason;
  /** 消息 */
  private byte[] msg;

  /** channel id */
  public ForwardLoginToGateRequest setChannelID(String channelID) {
    this.channelID = channelID;
    return this;
  }

  /** channel id */
  public String getChannelID() {
    return this.channelID;
  }

  /** 关闭channel的原因，没有则不关闭 */
  public ForwardLoginToGateRequest setCloseReason(String closeReason) {
    this.closeReason = closeReason;
    return this;
  }

  /** 关闭channel的原因，没有则不关闭 */
  public String getCloseReason() {
    return this.closeReason;
  }

  /** 消息 */
  public ForwardLoginToGateRequest setMsg(byte[] msg) {
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
    ByteBufUtil.writeString(buf, this.closeReason);
    ByteBufUtil.writeBytesWithLengthFlag(buf, this.msg);
  }

  @Override
  public ForwardLoginToGateRequest read(ByteBuf buf) {
    int size52413035;
    this.channelID = ByteBufUtil.readString(buf);
    this.closeReason = ByteBufUtil.readString(buf);
    this.msg = ByteBufUtil.readBytesWithLengthFlag(buf);
    return this;
  }

  @Override
  public int id() {
    return 14;
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
