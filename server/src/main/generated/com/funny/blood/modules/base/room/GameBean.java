package com.funny.blood.modules.base.room;

import io.netty.buffer.ByteBuf;
import shell.net.Bean;
import shell.nio.ByteBufUtil;

/** 游戏 */
public class GameBean implements Bean<GameBean> {
  public GameBean() {}

  public GameBean(com.funny.blood.modules.base.room.GameType type, java.util.List<com.funny.blood.modules.base.room.RoomBean> rooms) {
    this.type = type;
    this.rooms = rooms;
  }

  /** 游戏类型[1:捕鱼] */
  private com.funny.blood.modules.base.room.GameType type;
  /** 房间列表 */
  private java.util.List<com.funny.blood.modules.base.room.RoomBean> rooms = new java.util.ArrayList<>();

  /** 游戏类型[1:捕鱼] */
  public GameBean setType(com.funny.blood.modules.base.room.GameType type) {
    this.type = type;
    return this;
  }

  /** 游戏类型[1:捕鱼] */
  public com.funny.blood.modules.base.room.GameType getType() {
    return this.type;
  }

  /** 房间列表 */
  public GameBean setRooms(java.util.List<com.funny.blood.modules.base.room.RoomBean> rooms) {
    this.rooms = rooms;
    return this;
  }

  /** 房间列表 */
  public java.util.List<com.funny.blood.modules.base.room.RoomBean> getRooms() {
    return this.rooms;
  }

  @Override
  public void write(ByteBuf buf) {
    ByteBufUtil.writeInt(buf, this.type != null ? this.type.getValue() : 0);
    ByteBufUtil.writeInt(buf, this.rooms.size());
    for (com.funny.blood.modules.base.room.RoomBean i_am_tmp : this.rooms) {
      i_am_tmp.write(buf);
    }
  }

  @Override
  public GameBean read(ByteBuf buf) {
    int size52413035;
    this.type = com.funny.blood.modules.base.room.GameType.valueOf(ByteBufUtil.readInt(buf));
    size52413035 = ByteBufUtil.readInt(buf);
    this.rooms = new java.util.ArrayList(size52413035);
    for (int i_am_tmp_i = 0; i_am_tmp_i < size52413035; ++i_am_tmp_i) {
      this.rooms.add(new com.funny.blood.modules.base.room.RoomBean().read(buf));
    }
    return this;
  }

  @Override
  public String toString() {
    return "GameBean{" +
           "type='" + type + '\'' +
           "rooms='" + rooms + '\'' +
           '}';
  }
}