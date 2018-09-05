package com.funny.blood.cfg;

import io.netty.buffer.ByteBuf;

/** Created by FreeMarker. 扎金花-参数 */
public class Q_zjh_paramGroup extends Q_zjh_param.Group {
  public Q_zjh_paramGroup(ByteBuf buf) {
    super(buf);
  }

  public void check(ConfigGroup group) {}

  @Override
  protected void check(Q_zjh_param data) {}
}
