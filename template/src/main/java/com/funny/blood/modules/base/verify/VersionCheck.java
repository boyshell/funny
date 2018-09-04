package com.funny.blood.modules.base.verify;

import shell.net.Message;
import shell.tool.message.MessageClassAnnotation;
import shell.tool.message.MessageFieldAnnotation;
import shell.tool.message.NoHandlerAnnotation;

@MessageClassAnnotation(from = Message.NodeType.CLIENT, to = Message.NodeType.GATE, desc = "版本验证")
public class VersionCheck {
  @NoHandlerAnnotation
  static class Request {
    @MessageFieldAnnotation(desc = "消息代码版本号")
    String messageCodeVersion;

    @MessageFieldAnnotation(desc = "配置代码版本号")
    String configCodeVersion;
  }

  static class Response {
    @MessageFieldAnnotation(desc = "如果存在,则用该配置")
    byte[] config;

    @MessageFieldAnnotation(desc = "如果config为空,则根据该配置数据版本号去获取配置")
    int configDataVersion;
  }

  enum Error {
    @MessageFieldAnnotation(desc = "消息代码不一致")
    MESSAGE_CODE,
    @MessageFieldAnnotation(desc = "配置代码不一致")
    CONFIG_CODE,
    @MessageFieldAnnotation(desc = "配置数据不一致")
    CONFIG_DATA,
    ;
  }
}
