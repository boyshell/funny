package com.funny.blood.modules.base.hall;

import io.netty.buffer.ByteBuf;
import shell.net.Bean;
import shell.nio.ByteBufUtil;

/** 大厅 */
public class HallBean implements Bean<HallBean> {
  public HallBean() {}

  public HallBean(int userID, java.util.List<Integer> values) {
    this.userID = userID;
    this.values = values;
  }

  /** 用户ID */
  private int userID;
  /** 值(参见UpdateValue) */
  private java.util.List<Integer> values = new java.util.ArrayList<>();

  /** 用户ID */
  public HallBean setUserID(int userID) {
    this.userID = userID;
    return this;
  }

  /** 用户ID */
  public int getUserID() {
    return this.userID;
  }

  /** 值(参见UpdateValue) */
  public HallBean setValues(java.util.List<Integer> values) {
    this.values = values;
    return this;
  }

  /** 值(参见UpdateValue) */
  public java.util.List<Integer> getValues() {
    return this.values;
  }

  @Override
  public void write(ByteBuf buf) {
    ByteBufUtil.writeInt(buf, this.userID);
    ByteBufUtil.writeInt(buf, this.values.size());
    for (int i_am_tmp : this.values) {
      ByteBufUtil.writeInt(buf, i_am_tmp);
    }
  }

  @Override
  public HallBean read(ByteBuf buf) {
    int size52413035;
    this.userID = ByteBufUtil.readInt(buf);
    size52413035 = ByteBufUtil.readInt(buf);
    this.values = new java.util.ArrayList(size52413035);
    for (int i_am_tmp_i = 0; i_am_tmp_i < size52413035; ++i_am_tmp_i) {
      this.values.add(ByteBufUtil.readInt(buf));
    }
    return this;
  }

  @Override
  public String toString() {
    return "HallBean{" +
           "userID='" + userID + '\'' +
           "values='" + values + '\'' +
           '}';
  }
}