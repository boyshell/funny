package com.funny.blood.modules.base.login;


import io.netty.buffer.ByteBuf;
import shell.net.Message;
import shell.nio.ByteBufUtil;

import javax.annotation.Nullable;

import static shell.net.Message.NodeType.GATE;
import static shell.net.Message.NodeType.CLIENT;

/** 版本验证 */
public class VersionCheckResponse implements Message {
  public VersionCheckResponse() {}

  public VersionCheckResponse(byte[] config, int configDataVersion) {
    this.config = config;
    this.configDataVersion = configDataVersion;
  }

  /** 如果存在,则用该配置 */
  private byte[] config;
  /** 如果config为空,则根据该配置数据版本号去获取配置 */
  private int configDataVersion;

  /** 如果存在,则用该配置 */
  public VersionCheckResponse setConfig(byte[] config) {
    this.config = config;
    return this;
  }

  /** 如果存在,则用该配置 */
  public byte[] getConfig() {
    return this.config;
  }

  /** 如果config为空,则根据该配置数据版本号去获取配置 */
  public VersionCheckResponse setConfigDataVersion(int configDataVersion) {
    this.configDataVersion = configDataVersion;
    return this;
  }

  /** 如果config为空,则根据该配置数据版本号去获取配置 */
  public int getConfigDataVersion() {
    return this.configDataVersion;
  }

  @Override
  public void write(ByteBuf buf) {
    ByteBufUtil.writeBytesWithLengthFlag(buf, this.config);
    ByteBufUtil.writeInt(buf, this.configDataVersion);
  }

  @Override
  public VersionCheckResponse read(ByteBuf buf) {
    int size52413035;
    this.config = ByteBufUtil.readBytesWithLengthFlag(buf);
    this.configDataVersion = ByteBufUtil.readInt(buf);
    return this;
  }

  @Override
  public String toString() {
    return "VersionCheckResponse{" +
           "config='" + config + '\'' +
           "configDataVersion='" + configDataVersion + '\'' +
           '}';
  }

  @Override
  public int id() {
    return 5;
  }

  @Override
  public NodeType from() {
    return GATE;
  }

  @Override
  public NodeType to() {
    return CLIENT;
  }

  @Nullable
  public Message error(int e) {
    return new VersionCheckError(e);
  }
}
