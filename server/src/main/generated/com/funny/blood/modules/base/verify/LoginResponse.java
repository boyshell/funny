package com.funny.blood.modules.base.verify;


import io.netty.buffer.ByteBuf;
import shell.net.Message;
import shell.nio.ByteBufUtil;

import javax.annotation.Nullable;

import static shell.net.Message.NodeType.GATE;
import static shell.net.Message.NodeType.CLIENT;

/** 登录 */
public class LoginResponse implements Message {
  public LoginResponse() {}

  public LoginResponse(long userID, long ctime, long stime) {
    this.userID = userID;
    this.ctime = ctime;
    this.stime = stime;
  }

  /** 账号ID */
  private long userID;
  /** 前端unix时间戳 */
  private long ctime;
  /** 后端unix时间戳 */
  private long stime;

  /** 账号ID */
  public LoginResponse setUserID(long userID) {
    this.userID = userID;
    return this;
  }

  /** 账号ID */
  public long getUserID() {
    return this.userID;
  }

  /** 前端unix时间戳 */
  public LoginResponse setCtime(long ctime) {
    this.ctime = ctime;
    return this;
  }

  /** 前端unix时间戳 */
  public long getCtime() {
    return this.ctime;
  }

  /** 后端unix时间戳 */
  public LoginResponse setStime(long stime) {
    this.stime = stime;
    return this;
  }

  /** 后端unix时间戳 */
  public long getStime() {
    return this.stime;
  }

  @Override
  public void write(ByteBuf buf) {
    ByteBufUtil.writeLong(buf, this.userID);
    ByteBufUtil.writeLong(buf, this.ctime);
    ByteBufUtil.writeLong(buf, this.stime);
  }

  @Override
  public LoginResponse read(ByteBuf buf) {
    int size52413035;
    this.userID = ByteBufUtil.readLong(buf);
    this.ctime = ByteBufUtil.readLong(buf);
    this.stime = ByteBufUtil.readLong(buf);
    return this;
  }

  @Override
  public int id() {
    return 2;
  }

  @Override
  public NodeType from() {
    return GATE;
  }

  @Override
  public NodeType to() {
    return CLIENT;
  }

  @Nullable
  public Message error(int e) {
    return new LoginError(e);
  }
}
