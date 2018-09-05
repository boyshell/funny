package com.funny.blood.modules.poker.zjh;


import io.netty.buffer.ByteBuf;
import shell.net.Message;
import shell.nio.ByteBufUtil;

import javax.annotation.Nullable;

import static shell.net.Message.NodeType.GAME;
import static shell.net.Message.NodeType.CLIENT;

/** 测试 */
public class Test2Request implements Message {
  public Test2Request() {}

  public Test2Request(short server, String account, boolean adult, int timestamp, String md5, short screenWidth, short screenHeight, long time) {
    this.server = server;
    this.account = account;
    this.adult = adult;
    this.timestamp = timestamp;
    this.md5 = md5;
    this.screenWidth = screenWidth;
    this.screenHeight = screenHeight;
    this.time = time;
  }

  /** 服务器 */
  private short server;
  /** 帐号 */
  private String account;
  /** 是否成年 */
  private boolean adult;
  /** 时间戳 */
  private int timestamp;
  /** MD5 */
  private String md5;
  /** 显示器宽(像素) */
  private short screenWidth;
  /** 显示器高(像素) */
  private short screenHeight;
  /** 前端unix时间戳 */
  private long time;

  /** 服务器 */
  public Test2Request setServer(short server) {
    this.server = server;
    return this;
  }

  /** 服务器 */
  public short getServer() {
    return this.server;
  }

  /** 帐号 */
  public Test2Request setAccount(String account) {
    this.account = account;
    return this;
  }

  /** 帐号 */
  public String getAccount() {
    return this.account;
  }

  /** 是否成年 */
  public Test2Request setAdult(boolean adult) {
    this.adult = adult;
    return this;
  }

  /** 是否成年 */
  public boolean getAdult() {
    return this.adult;
  }

  /** 时间戳 */
  public Test2Request setTimestamp(int timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /** 时间戳 */
  public int getTimestamp() {
    return this.timestamp;
  }

  /** MD5 */
  public Test2Request setMd5(String md5) {
    this.md5 = md5;
    return this;
  }

  /** MD5 */
  public String getMd5() {
    return this.md5;
  }

  /** 显示器宽(像素) */
  public Test2Request setScreenWidth(short screenWidth) {
    this.screenWidth = screenWidth;
    return this;
  }

  /** 显示器宽(像素) */
  public short getScreenWidth() {
    return this.screenWidth;
  }

  /** 显示器高(像素) */
  public Test2Request setScreenHeight(short screenHeight) {
    this.screenHeight = screenHeight;
    return this;
  }

  /** 显示器高(像素) */
  public short getScreenHeight() {
    return this.screenHeight;
  }

  /** 前端unix时间戳 */
  public Test2Request setTime(long time) {
    this.time = time;
    return this;
  }

  /** 前端unix时间戳 */
  public long getTime() {
    return this.time;
  }

  @Override
  public void write(ByteBuf buf) {
    ByteBufUtil.writeShort(buf, this.server);
    ByteBufUtil.writeString(buf, this.account);
    ByteBufUtil.writeBoolean(buf, this.adult);
    ByteBufUtil.writeInt(buf, this.timestamp);
    ByteBufUtil.writeString(buf, this.md5);
    ByteBufUtil.writeShort(buf, this.screenWidth);
    ByteBufUtil.writeShort(buf, this.screenHeight);
    ByteBufUtil.writeLong(buf, this.time);
  }

  @Override
  public Test2Request read(ByteBuf buf) {
    int size52413035;
    this.server = ByteBufUtil.readShort(buf);
    this.account = ByteBufUtil.readString(buf);
    this.adult = ByteBufUtil.readBoolean(buf);
    this.timestamp = ByteBufUtil.readInt(buf);
    this.md5 = ByteBufUtil.readString(buf);
    this.screenWidth = ByteBufUtil.readShort(buf);
    this.screenHeight = ByteBufUtil.readShort(buf);
    this.time = ByteBufUtil.readLong(buf);
    return this;
  }

  @Override
  public int id() {
    return 8;
  }

  @Override
  public NodeType from() {
    return GAME;
  }

  @Override
  public NodeType to() {
    return CLIENT;
  }

  @Nullable
  public Message error(int e) {
    return null;
  }
}
