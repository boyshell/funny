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

  public LoginResponse(com.funny.blood.modules.base.hall.HallBean hall) {
    this.hall = hall;
  }

  /** 大厅 */
  private com.funny.blood.modules.base.hall.HallBean hall;

  /** 大厅 */
  public LoginResponse setHall(com.funny.blood.modules.base.hall.HallBean hall) {
    this.hall = hall;
    return this;
  }

  /** 大厅 */
  public com.funny.blood.modules.base.hall.HallBean getHall() {
    return this.hall;
  }

  @Override
  public void write(ByteBuf buf) {
    ByteBufUtil.writeBean(buf, this.hall);
  }

  @Override
  public LoginResponse read(ByteBuf buf) {
    int size52413035;
    this.hall = ByteBufUtil.readBean(buf, com.funny.blood.modules.base.hall.HallBean.class);
    return this;
  }

  @Override
  public String toString() {
    return "LoginResponse{" +
           "hall='" + hall + '\'' +
           '}';
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
