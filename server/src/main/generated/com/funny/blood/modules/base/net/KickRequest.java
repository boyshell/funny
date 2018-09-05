package com.funny.blood.modules.base.net;


import io.netty.buffer.ByteBuf;
import shell.net.Message;
import shell.nio.ByteBufUtil;

import javax.annotation.Nullable;

import static shell.net.Message.NodeType.GATE;
import static shell.net.Message.NodeType.CLIENT;

/** 踢人 */
public class KickRequest implements Message {
  public KickRequest() {}

  public KickRequest(com.funny.blood.modules.base.net.KickType type) {
    this.type = type;
  }

  /** 为何踢人[1:版本不一致][2:验证未通过][3:多次发送登录消息][4:顶号][5:流程错误][6:非法消息] */
  private com.funny.blood.modules.base.net.KickType type;

  /** 为何踢人[1:版本不一致][2:验证未通过][3:多次发送登录消息][4:顶号][5:流程错误][6:非法消息] */
  public KickRequest setType(com.funny.blood.modules.base.net.KickType type) {
    this.type = type;
    return this;
  }

  /** 为何踢人[1:版本不一致][2:验证未通过][3:多次发送登录消息][4:顶号][5:流程错误][6:非法消息] */
  public com.funny.blood.modules.base.net.KickType getType() {
    return this.type;
  }

  @Override
  public void write(ByteBuf buf) {
    ByteBufUtil.writeInt(buf, this.type != null ? this.type.getValue() : 0);
  }

  @Override
  public KickRequest read(ByteBuf buf) {
    int size52413035;
    this.type = com.funny.blood.modules.base.net.KickType.valueOf(ByteBufUtil.readInt(buf));
    return this;
  }

  @Override
  public int id() {
    return 9;
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
    return null;
  }
}
