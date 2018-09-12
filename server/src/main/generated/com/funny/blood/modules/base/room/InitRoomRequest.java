package com.funny.blood.modules.base.room;


import io.netty.buffer.ByteBuf;
import shell.net.Message;
import shell.nio.ByteBufUtil;

import javax.annotation.Nullable;

import static shell.net.Message.NodeType.HALL;
import static shell.net.Message.NodeType.GATE;

/** 初始化房间 */
public class InitRoomRequest implements Message {
  public InitRoomRequest() {}

  public InitRoomRequest(java.util.List<com.funny.blood.modules.base.room.RoomServerBean> servers) {
    this.servers = servers;
  }

  /** 房间服务器 */
  private java.util.List<com.funny.blood.modules.base.room.RoomServerBean> servers = new java.util.ArrayList<>();

  /** 房间服务器 */
  public InitRoomRequest setServers(java.util.List<com.funny.blood.modules.base.room.RoomServerBean> servers) {
    this.servers = servers;
    return this;
  }

  /** 房间服务器 */
  public java.util.List<com.funny.blood.modules.base.room.RoomServerBean> getServers() {
    return this.servers;
  }

  @Override
  public void write(ByteBuf buf) {
    ByteBufUtil.writeInt(buf, this.servers.size());
    for (com.funny.blood.modules.base.room.RoomServerBean i_am_tmp : this.servers) {
      i_am_tmp.write(buf);
    }
  }

  @Override
  public InitRoomRequest read(ByteBuf buf) {
    int size52413035;
    size52413035 = ByteBufUtil.readInt(buf);
    this.servers = new java.util.ArrayList(size52413035);
    for (int i_am_tmp_i = 0; i_am_tmp_i < size52413035; ++i_am_tmp_i) {
      this.servers.add(new com.funny.blood.modules.base.room.RoomServerBean().read(buf));
    }
    return this;
  }

  @Override
  public String toString() {
    return "InitRoomRequest{" +
           "servers='" + servers + '\'' +
           '}';
  }

  @Override
  public int id() {
    return 34;
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
