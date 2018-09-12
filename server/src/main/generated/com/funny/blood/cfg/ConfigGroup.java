package com.funny.blood.cfg;

import com.funny.blood.modules.base.login.VersionCheckResponse;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import shell.io.IOUtil;
import shell.net.Message;
import shell.nio.ByteBufUtil;

import java.io.IOException;
import java.io.InputStream;

import static com.google.common.base.Preconditions.checkArgument;

/** Created by FreeMarker. DO NOT EDIT!!! */
public class ConfigGroup {
  public final String CODE_VERSION = "4da7a93db1c19312d330e087a024399d";
  public final byte[] DATA_VERSION;
  public final Q_zjh_paramGroup q_zjh_paramGroup; // 扎金花-参数

  public ConfigGroup(InputStream is) throws IOException {
    ByteBuf buf = ByteBufAllocator.DEFAULT.buffer();
    try {
      byte[] bytes = IOUtil.readBytes(is);
      ByteBufUtil.writeBytes(buf, bytes, 0, bytes.length);

      checkArgument(CODE_VERSION.equals(ByteBufUtil.readString(buf)), "配置文件和程序版本不一致");
      this.DATA_VERSION =
          Message.encodeToBytes(
              new VersionCheckResponse().setConfigDataVersion(ByteBufUtil.readInt(buf)));

      try {
        this.q_zjh_paramGroup = new Q_zjh_paramGroup(buf);
      } catch (Throwable e) {
        throw new shell.game.misc.ConfigFileException(e.getMessage(), "扎金花-参数", e);
      }
    } finally {
      buf.release();
    }
  }

  public void check() {
    try {
      this.q_zjh_paramGroup.check(this);
    } catch (Throwable e) {
      throw new shell.game.misc.ConfigFileException(e.getMessage(), "扎金花-参数", e);
    }
  }
}
