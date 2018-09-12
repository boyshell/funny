package com.funny.blood.modules.base.room;


import io.netty.buffer.ByteBuf;
import shell.net.Message;
import shell.nio.ByteBufUtil;

import javax.annotation.Nullable;

import static shell.net.Message.NodeType.HALL;
import static shell.net.Message.NodeType.CLIENT;

/** 进入游戏 */
public class EnterRoomError implements Message {
  private int error;

  public EnterRoomError(int error) {
    this.error = error;
  }

  /** 在房间中 */
  public static byte[] IN_ROOM = Message.encodeToBytes(new EnterRoomError(1));
  /** 没有房间 */
  public static byte[] NO_ROOM = Message.encodeToBytes(new EnterRoomError(2));
  /** 房间满 */
  public static byte[] FULL = Message.encodeToBytes(new EnterRoomError(3));
  /** 系统错误 */
  public static byte[] SYS = Message.encodeToBytes(new EnterRoomError(4));

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
    return 29;
  }

  @Override
  public NodeType from() {
    return CLIENT;
  }

  @Override
  public NodeType to() {
    return HALL;
  }

  @Nullable
  public Message error(int e) {
    return null;
  }
}
