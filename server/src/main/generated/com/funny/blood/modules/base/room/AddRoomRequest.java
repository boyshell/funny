package com.funny.blood.modules.base.room;


import io.netty.buffer.ByteBuf;
import shell.net.Message;
import shell.nio.ByteBufUtil;

import javax.annotation.Nullable;

import static shell.net.Message.NodeType.HALL;
import static shell.net.Message.NodeType.GATE;

/** 添加房间 */
public class AddRoomRequest implements Message {
  public AddRoomRequest() {}

  public AddRoomRequest(com.funny.blood.modules.base.room.RoomServerBean server) {
    this.server = server;
  }

  /** 房间服务器 */
  private com.funny.blood.modules.base.room.RoomServerBean server;

  /** 房间服务器 */
  public AddRoomRequest setServer(com.funny.blood.modules.base.room.RoomServerBean server) {
    this.server = server;
    return this;
  }

  /** 房间服务器 */
  public com.funny.blood.modules.base.room.RoomServerBean getServer() {
    return this.server;
  }

  @Override
  public void write(ByteBuf buf) {
    ByteBufUtil.writeBean(buf, this.server);
  }

  @Override
  public AddRoomRequest read(ByteBuf buf) {
    int size52413035;
    this.server = ByteBufUtil.readBean(buf, com.funny.blood.modules.base.room.RoomServerBean.class);
    return this;
  }

  @Override
  public String toString() {
    return "AddRoomRequest{" +
           "server='" + server + '\'' +
           '}';
  }

  @Override
  public int id() {
    return 33;
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
