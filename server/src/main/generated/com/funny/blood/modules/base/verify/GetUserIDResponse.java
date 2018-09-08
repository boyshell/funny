package com.funny.blood.modules.base.verify;


import io.netty.buffer.ByteBuf;
import shell.net.Message;
import shell.nio.ByteBufUtil;

import javax.annotation.Nullable;

import static shell.net.Message.NodeType.LOGIN;
import static shell.net.Message.NodeType.GATE;

/** 获取用户ID */
public class GetUserIDResponse implements Message {
  public GetUserIDResponse() {}

  public GetUserIDResponse(String channelID, int userID, com.funny.blood.modules.base.verify.GetUserIDError error) {
    this.channelID = channelID;
    this.userID = userID;
    this.error = error;
  }

  /** channel id */
  private String channelID;
  /** 账号ID */
  private int userID;
  /** 错误码[1:系统错误][2:顶号] */
  private com.funny.blood.modules.base.verify.GetUserIDError error;

  /** channel id */
  public GetUserIDResponse setChannelID(String channelID) {
    this.channelID = channelID;
    return this;
  }

  /** channel id */
  public String getChannelID() {
    return this.channelID;
  }

  /** 账号ID */
  public GetUserIDResponse setUserID(int userID) {
    this.userID = userID;
    return this;
  }

  /** 账号ID */
  public int getUserID() {
    return this.userID;
  }

  /** 错误码[1:系统错误][2:顶号] */
  public GetUserIDResponse setError(com.funny.blood.modules.base.verify.GetUserIDError error) {
    this.error = error;
    return this;
  }

  /** 错误码[1:系统错误][2:顶号] */
  public com.funny.blood.modules.base.verify.GetUserIDError getError() {
    return this.error;
  }

  @Override
  public void write(ByteBuf buf) {
    ByteBufUtil.writeString(buf, this.channelID);
    ByteBufUtil.writeInt(buf, this.userID);
    ByteBufUtil.writeInt(buf, this.error != null ? this.error.getValue() : 0);
  }

  @Override
  public GetUserIDResponse read(ByteBuf buf) {
    int size52413035;
    this.channelID = ByteBufUtil.readString(buf);
    this.userID = ByteBufUtil.readInt(buf);
    this.error = com.funny.blood.modules.base.verify.GetUserIDError.valueOf(ByteBufUtil.readInt(buf));
    return this;
  }

  @Override
  public String toString() {
    return "GetUserIDResponse{" +
           "channelID='" + channelID + '\'' +
           "userID='" + userID + '\'' +
           "error='" + error + '\'' +
           '}';
  }

  @Override
  public int id() {
    return 17;
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
