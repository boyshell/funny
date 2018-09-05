package com.funny.blood.modules.base.verify;


import io.netty.buffer.ByteBuf;
import shell.net.Message;
import shell.nio.ByteBufUtil;

import javax.annotation.Nullable;

import static shell.net.Message.NodeType.CLIENT;
import static shell.net.Message.NodeType.GATE;

/** 登录 */
public class LoginRequest implements Message {
  public LoginRequest() {}

  public LoginRequest(String account, int timestamp, String md5, long time) {
    this.account = account;
    this.timestamp = timestamp;
    this.md5 = md5;
    this.time = time;
  }

  /** 帐号 */
  private String account;
  /** 时间戳 */
  private int timestamp;
  /** MD5 */
  private String md5;
  /** 前端unix时间戳 */
  private long time;

  /** 帐号 */
  public LoginRequest setAccount(String account) {
    this.account = account;
    return this;
  }

  /** 帐号 */
  public String getAccount() {
    return this.account;
  }

  /** 时间戳 */
  public LoginRequest setTimestamp(int timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /** 时间戳 */
  public int getTimestamp() {
    return this.timestamp;
  }

  /** MD5 */
  public LoginRequest setMd5(String md5) {
    this.md5 = md5;
    return this;
  }

  /** MD5 */
  public String getMd5() {
    return this.md5;
  }

  /** 前端unix时间戳 */
  public LoginRequest setTime(long time) {
    this.time = time;
    return this;
  }

  /** 前端unix时间戳 */
  public long getTime() {
    return this.time;
  }

  @Override
  public void write(ByteBuf buf) {
    ByteBufUtil.writeString(buf, this.account);
    ByteBufUtil.writeInt(buf, this.timestamp);
    ByteBufUtil.writeString(buf, this.md5);
    ByteBufUtil.writeLong(buf, this.time);
  }

  @Override
  public LoginRequest read(ByteBuf buf) {
    int size52413035;
    this.account = ByteBufUtil.readString(buf);
    this.timestamp = ByteBufUtil.readInt(buf);
    this.md5 = ByteBufUtil.readString(buf);
    this.time = ByteBufUtil.readLong(buf);
    return this;
  }

  @Override
  public int id() {
    return 1;
  }

  @Override
  public NodeType from() {
    return CLIENT;
  }

  @Override
  public NodeType to() {
    return GATE;
  }

  @Nullable
  public Message error(int e) {
    return new LoginError(e);
  }
}
