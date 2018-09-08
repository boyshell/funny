package com.funny.blood.modules.base.room;

import io.netty.buffer.ByteBuf;
import shell.net.Bean;
import shell.nio.ByteBufUtil;

/** 房间 */
public class RoomBean implements Bean<RoomBean> {
  public RoomBean() {}

  public RoomBean(int id, int max, int num, int needChip) {
    this.id = id;
    this.max = max;
    this.num = num;
    this.needChip = needChip;
  }

  /** 房间编号 */
  private int id;
  /** 人数上限 */
  private int max;
  /** 当前人数 */
  private int num;
  /** 准入筹码数量 */
  private int needChip;

  /** 房间编号 */
  public RoomBean setId(int id) {
    this.id = id;
    return this;
  }

  /** 房间编号 */
  public int getId() {
    return this.id;
  }

  /** 人数上限 */
  public RoomBean setMax(int max) {
    this.max = max;
    return this;
  }

  /** 人数上限 */
  public int getMax() {
    return this.max;
  }

  /** 当前人数 */
  public RoomBean setNum(int num) {
    this.num = num;
    return this;
  }

  /** 当前人数 */
  public int getNum() {
    return this.num;
  }

  /** 准入筹码数量 */
  public RoomBean setNeedChip(int needChip) {
    this.needChip = needChip;
    return this;
  }

  /** 准入筹码数量 */
  public int getNeedChip() {
    return this.needChip;
  }

  @Override
  public void write(ByteBuf buf) {
    ByteBufUtil.writeInt(buf, this.id);
    ByteBufUtil.writeInt(buf, this.max);
    ByteBufUtil.writeInt(buf, this.num);
    ByteBufUtil.writeInt(buf, this.needChip);
  }

  @Override
  public RoomBean read(ByteBuf buf) {
    int size52413035;
    this.id = ByteBufUtil.readInt(buf);
    this.max = ByteBufUtil.readInt(buf);
    this.num = ByteBufUtil.readInt(buf);
    this.needChip = ByteBufUtil.readInt(buf);
    return this;
  }

  @Override
  public String toString() {
    return "RoomBean{" +
           "id='" + id + '\'' +
           "max='" + max + '\'' +
           "num='" + num + '\'' +
           "needChip='" + needChip + '\'' +
           '}';
  }
}