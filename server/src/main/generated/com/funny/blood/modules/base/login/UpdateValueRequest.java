package com.funny.blood.modules.base.login;


import io.netty.buffer.ByteBuf;
import shell.net.Message;
import shell.nio.ByteBufUtil;

import javax.annotation.Nullable;

import static shell.net.Message.NodeType.HALL;
import static shell.net.Message.NodeType.CLIENT;

/** 更新值 */
public class UpdateValueRequest implements Message {
  public UpdateValueRequest() {}

  public UpdateValueRequest(com.funny.blood.modules.base.login.ValueType type, int value) {
    this.type = type;
    this.value = value;
  }

  /** 值类型[1:筹码] */
  private com.funny.blood.modules.base.login.ValueType type;
  /** 值 */
  private int value;

  /** 值类型[1:筹码] */
  public UpdateValueRequest setType(com.funny.blood.modules.base.login.ValueType type) {
    this.type = type;
    return this;
  }

  /** 值类型[1:筹码] */
  public com.funny.blood.modules.base.login.ValueType getType() {
    return this.type;
  }

  /** 值 */
  public UpdateValueRequest setValue(int value) {
    this.value = value;
    return this;
  }

  /** 值 */
  public int getValue() {
    return this.value;
  }

  @Override
  public void write(ByteBuf buf) {
    ByteBufUtil.writeInt(buf, this.type != null ? this.type.getValue() : 0);
    ByteBufUtil.writeInt(buf, this.value);
  }

  @Override
  public UpdateValueRequest read(ByteBuf buf) {
    int size52413035;
    this.type = com.funny.blood.modules.base.login.ValueType.valueOf(ByteBufUtil.readInt(buf));
    this.value = ByteBufUtil.readInt(buf);
    return this;
  }

  @Override
  public String toString() {
    return "UpdateValueRequest{" +
           "type='" + type + '\'' +
           "value='" + value + '\'' +
           '}';
  }

  @Override
  public int id() {
    return 21;
  }

  @Override
  public NodeType from() {
    return HALL;
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
