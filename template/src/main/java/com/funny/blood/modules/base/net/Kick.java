package com.funny.blood.modules.base.net;

import shell.net.Message;
import shell.tool.message.MessageClassAnnotation;
import shell.tool.message.MessageFieldAnnotation;

@MessageClassAnnotation(from = Message.NodeType.GATE, to = Message.NodeType.CLIENT, desc = "踢人")
public class Kick {
  static class Request {
    @MessageFieldAnnotation(desc = "为何踢人")
    KickType type;
  }
}
