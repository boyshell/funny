package com.funny.blood.modules.base.net;

import shell.net.Message;
import shell.tool.message.MessageClassAnnotation;
import shell.tool.message.MessageFieldAnnotation;

@MessageClassAnnotation(from = Message.NodeType.GATE, to = Message.NodeType.HALL, desc = "转发")
public class ForwardClientToHall {
  static class Request {
    @MessageFieldAnnotation(desc = "用户ID")
    int userID;

    @MessageFieldAnnotation(desc = "消息")
    byte[] msg;
  }
}
