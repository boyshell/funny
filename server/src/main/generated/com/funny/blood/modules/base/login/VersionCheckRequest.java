package com.funny.blood.modules.base.login;


import io.netty.buffer.ByteBuf;
import shell.net.Message;
import shell.nio.ByteBufUtil;

import javax.annotation.Nullable;

import static shell.net.Message.NodeType.CLIENT;
import static shell.net.Message.NodeType.GATE;

/** 版本验证 */
public class VersionCheckRequest implements Message {
  public VersionCheckRequest() {}

  public VersionCheckRequest(String messageCodeVersion, String configCodeVersion) {
    this.messageCodeVersion = messageCodeVersion;
    this.configCodeVersion = configCodeVersion;
  }

  /** 消息代码版本号 */
  private String messageCodeVersion;
  /** 配置代码版本号 */
  private String configCodeVersion;

  /** 消息代码版本号 */
  public VersionCheckRequest setMessageCodeVersion(String messageCodeVersion) {
    this.messageCodeVersion = messageCodeVersion;
    return this;
  }

  /** 消息代码版本号 */
  public String getMessageCodeVersion() {
    return this.messageCodeVersion;
  }

  /** 配置代码版本号 */
  public VersionCheckRequest setConfigCodeVersion(String configCodeVersion) {
    this.configCodeVersion = configCodeVersion;
    return this;
  }

  /** 配置代码版本号 */
  public String getConfigCodeVersion() {
    return this.configCodeVersion;
  }

  @Override
  public void write(ByteBuf buf) {
    ByteBufUtil.writeString(buf, this.messageCodeVersion);
    ByteBufUtil.writeString(buf, this.configCodeVersion);
  }

  @Override
  public VersionCheckRequest read(ByteBuf buf) {
    int size52413035;
    this.messageCodeVersion = ByteBufUtil.readString(buf);
    this.configCodeVersion = ByteBufUtil.readString(buf);
    return this;
  }

  @Override
  public String toString() {
    return "VersionCheckRequest{" +
           "messageCodeVersion='" + messageCodeVersion + '\'' +
           "configCodeVersion='" + configCodeVersion + '\'' +
           '}';
  }

  @Override
  public int id() {
    return 4;
  }

  @Override
  public NodeType from() {
    return CLIENT;
  }

  @Override
  public NodeType to() {
    return GATE;
  }

  @Nullable
  public Message error(int e) {
    return new VersionCheckError(e);
  }
}
