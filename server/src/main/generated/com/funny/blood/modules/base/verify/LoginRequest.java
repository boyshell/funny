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

  public LoginRequest(String account) {
    this.account = account;
  }

  /** 帐号 */
  private String account;

  /** 帐号 */
  public LoginRequest setAccount(String account) {
    this.account = account;
    return this;
  }

  /** 帐号 */
  public String getAccount() {
    return this.account;
  }

  @Override
  public void write(ByteBuf buf) {
    ByteBufUtil.writeString(buf, this.account);
  }

  @Override
  public LoginRequest read(ByteBuf buf) {
    int size52413035;
    this.account = ByteBufUtil.readString(buf);
    return this;
  }

  @Override
  public String toString() {
    return "LoginRequest{" +
           "account='" + account + '\'' +
           '}';
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
