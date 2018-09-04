package com.funny.blood.modules.base.verify;


import io.netty.buffer.ByteBuf;
import shell.net.Message;
import shell.nio.ByteBufUtil;

import javax.annotation.Nullable;

import static shell.net.Message.NodeType.GATE;
import static shell.net.Message.NodeType.CLIENT;

/** 版本验证 */
public class VersionCheckError implements Message {
  private int error;

  public VersionCheckError(int error) {
    this.error = error;
  }

  /** 消息代码不一致 */
  public static byte[] MESSAGE_CODE = Message.encodeToBytes(new VersionCheckError(1));
  /** 配置代码不一致 */
  public static byte[] CONFIG_CODE = Message.encodeToBytes(new VersionCheckError(2));
  /** 配置数据不一致 */
  public static byte[] CONFIG_DATA = Message.encodeToBytes(new VersionCheckError(3));

  public int getError() {
    return this.error;
  }

  @Override
  public void write(ByteBuf buf) {
    ByteBufUtil.writeInt(buf, error);
  }

  @Override
  public Message read(ByteBuf buf) {
    error = ByteBufUtil.readInt(buf);
    return this;
  }

  @Override
  public int id() {
    return 6;
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
    return null;
  }
}
