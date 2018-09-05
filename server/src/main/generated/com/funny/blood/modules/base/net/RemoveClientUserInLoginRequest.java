package com.funny.blood.modules.base.net;


import io.netty.buffer.ByteBuf;
import shell.net.Message;
import shell.nio.ByteBufUtil;

import javax.annotation.Nullable;

import static shell.net.Message.NodeType.GATE;
import static shell.net.Message.NodeType.LOGIN;

/** 在login服务器移除一个client的用户 */
public class RemoveClientUserInLoginRequest implements Message {
  public RemoveClientUserInLoginRequest() {}

  public RemoveClientUserInLoginRequest(String channelID) {
    this.channelID = channelID;
  }

  /** channel id */
  private String channelID;

  /** channel id */
  public RemoveClientUserInLoginRequest setChannelID(String channelID) {
    this.channelID = channelID;
    return this;
  }

  /** channel id */
  public String getChannelID() {
    return this.channelID;
  }

  @Override
  public void write(ByteBuf buf) {
    ByteBufUtil.writeString(buf, this.channelID);
  }

  @Override
  public RemoveClientUserInLoginRequest read(ByteBuf buf) {
    int size52413035;
    this.channelID = ByteBufUtil.readString(buf);
    return this;
  }

  @Override
  public int id() {
    return 16;
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
