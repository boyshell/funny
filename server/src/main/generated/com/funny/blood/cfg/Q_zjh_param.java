package com.funny.blood.cfg;

import shell.nio.ByteBufUtil;
import io.netty.buffer.ByteBuf;

/** Created by FreeMarker. DO NOT EDIT!!! 扎金花-参数 */
public class Q_zjh_param {
  public final int q_id; // ID
  public final String q_value; // 值

  public static class Builder {
    public final int q_id; // ID
    public final String q_value; // 值
    protected Builder(ByteBuf buf) {
      try {
        this.q_id = ByteBufUtil.readInt(buf);
      } catch (Throwable e) {
        throw new shell.game.misc.ConfigFieldException(e.getMessage(), "q_id", e);
      }
      try {
        this.q_value = ByteBufUtil.readString(buf);
      } catch (Throwable e) {
        throw new shell.game.misc.ConfigFieldException(e.getMessage(), "q_value", e);
      }
    }
  }

  protected Q_zjh_param(ByteBuf buf) {
    Builder builder = new Builder(buf);
    this.q_id = builder.q_id;
    this.q_value = builder.q_value;
  }

  public static abstract class Group {

    private Q_zjh_param[] datas;

    protected abstract void check(Q_zjh_param data);

    protected Group(ByteBuf buf) {

      datas = new Q_zjh_param[ByteBufUtil.readInt(buf)];
      for (int i = 0; i < datas.length; ++i) {
        try {
          Q_zjh_param data = new Q_zjh_param(buf);
          check(data);
          datas[i] = data;
        } catch (Throwable e) {
          throw new shell.game.misc.ConfigRowException(e.getMessage(), i + 6, e);
        }
      }
    }

    protected final Q_zjh_param[] getAndSetNull() {
      Q_zjh_param[] r = get();
      this.datas = null;
      return r;
    }

    protected final Q_zjh_param[] get() {
      return datas;
    }
  }
}
