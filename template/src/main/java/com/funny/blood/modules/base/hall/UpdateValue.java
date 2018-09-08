package com.funny.blood.modules.base.hall;

import shell.net.Message;
import shell.tool.message.MessageClassAnnotation;
import shell.tool.message.MessageFieldAnnotation;

@MessageClassAnnotation(from = Message.NodeType.HALL, to = Message.NodeType.CLIENT, desc = "更新值")
public class UpdateValue {
  static class Request {
    @MessageFieldAnnotation(desc = "值类型")
    ValueType type;

    @MessageFieldAnnotation(desc = "值")
    int value;
  }
}
