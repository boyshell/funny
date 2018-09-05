package com.funny.blood.modules.base.verify;


import io.netty.buffer.ByteBuf;
import shell.net.Message;
import shell.nio.ByteBufUtil;

import javax.annotation.Nullable;

import static shell.net.Message.NodeType.GATE;
import static shell.net.Message.NodeType.CLIENT;

/** 登录 */
public class LoginError implements Message {
  private int error;

  public LoginError(int error) {
    this.error = error;
  }

  /** 帐号名称非法 */
  public static byte[] ILLEGAL_USER_NAME = Message.encodeToBytes(new LoginError(1));
  /** 主机地址非法 */
  public static byte[] ILLEGAL_HOST = Message.encodeToBytes(new LoginError(2));
  /** MD5校验失败 */
  public static byte[] ILLEGAL_MD5 = Message.encodeToBytes(new LoginError(3));
  /** 被封禁的帐号 */
  public static byte[] FROZEN = Message.encodeToBytes(new LoginError(4));
  /** 登录超时 */
  public static byte[] OVER_TIME = Message.encodeToBytes(new LoginError(5));
  /** 系统错误 */
  public static byte[] SYSTEM = Message.encodeToBytes(new LoginError(6));
  /** 发生极小概率事件,请重新登录 */
  public static byte[] RELOGIN_PLEASE = Message.encodeToBytes(new LoginError(7));
  /** 被顶号 */
  public static byte[] REPLACE = Message.encodeToBytes(new LoginError(8));
  /** 重复登录 */
  public static byte[] DUPLICATE_LOGIN = Message.encodeToBytes(new LoginError(9));

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
    return 3;
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
