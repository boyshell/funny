package com.funny.blood.modules.base.net;

import shell.net.Message;
import shell.tool.message.MessageClassAnnotation;
import shell.tool.message.MessageFieldAnnotation;

@MessageClassAnnotation(from = Message.NodeType.GATE, to = Message.NodeType.GAME, desc = "转发")
public class ForwardGateToGame {
  static class Request {
    @MessageFieldAnnotation(desc = "channel id")
    String channelID;

    @MessageFieldAnnotation(desc = "消息")
    byte[] msg;
  }
}
