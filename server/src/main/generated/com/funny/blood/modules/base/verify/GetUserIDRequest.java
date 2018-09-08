package com.funny.blood.modules.base.verify;


import io.netty.buffer.ByteBuf;
import shell.net.Message;
import shell.nio.ByteBufUtil;

import javax.annotation.Nullable;

import static shell.net.Message.NodeType.GATE;
import static shell.net.Message.NodeType.LOGIN;

/** 获取用户ID */
public class GetUserIDRequest implements Message {
  public GetUserIDRequest() {}

  public GetUserIDRequest(String channelID, String account) {
    this.channelID = channelID;
    this.account = account;
  }

  /** channel id */
  private String channelID;
  /** 帐号 */
  private String account;

  /** channel id */
  public GetUserIDRequest setChannelID(String channelID) {
    this.channelID = channelID;
    return this;
  }

  /** channel id */
  public String getChannelID() {
    return this.channelID;
  }

  /** 帐号 */
  public GetUserIDRequest setAccount(String account) {
    this.account = account;
    return this;
  }

  /** 帐号 */
  public String getAccount() {
    return this.account;
  }

  @Override
  public void write(ByteBuf buf) {
    ByteBufUtil.writeString(buf, this.channelID);
    ByteBufUtil.writeString(buf, this.account);
  }

  @Override
  public GetUserIDRequest read(ByteBuf buf) {
    int size52413035;
    this.channelID = ByteBufUtil.readString(buf);
    this.account = ByteBufUtil.readString(buf);
    return this;
  }

  @Override
  public String toString() {
    return "GetUserIDRequest{" +
           "channelID='" + channelID + '\'' +
           "account='" + account + '\'' +
           '}';
  }

  @Override
  public int id() {
    return 13;
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
