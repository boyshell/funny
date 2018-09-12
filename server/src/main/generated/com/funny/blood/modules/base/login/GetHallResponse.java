package com.funny.blood.modules.base.login;


import io.netty.buffer.ByteBuf;
import shell.net.Message;
import shell.nio.ByteBufUtil;

import javax.annotation.Nullable;

import static shell.net.Message.NodeType.HALL;
import static shell.net.Message.NodeType.GATE;

/** 登录事件 */
public class GetHallResponse implements Message {
  public GetHallResponse() {}

  public GetHallResponse(com.funny.blood.modules.base.login.HallBean hall) {
    this.hall = hall;
  }

  /** 大厅 */
  private com.funny.blood.modules.base.login.HallBean hall;

  /** 大厅 */
  public GetHallResponse setHall(com.funny.blood.modules.base.login.HallBean hall) {
    this.hall = hall;
    return this;
  }

  /** 大厅 */
  public com.funny.blood.modules.base.login.HallBean getHall() {
    return this.hall;
  }

  @Override
  public void write(ByteBuf buf) {
    ByteBufUtil.writeBean(buf, this.hall);
  }

  @Override
  public GetHallResponse read(ByteBuf buf) {
    int size52413035;
    this.hall = ByteBufUtil.readBean(buf, com.funny.blood.modules.base.login.HallBean.class);
    return this;
  }

  @Override
  public String toString() {
    return "GetHallResponse{" +
           "hall='" + hall + '\'' +
           '}';
  }

  @Override
  public int id() {
    return 24;
  }

  @Override
  public NodeType from() {
    return HALL;
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
