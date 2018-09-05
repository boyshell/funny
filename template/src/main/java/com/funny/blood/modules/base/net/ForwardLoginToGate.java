package com.funny.blood.modules.base.net;

import shell.net.Message;
import shell.tool.message.MessageClassAnnotation;
import shell.tool.message.MessageFieldAnnotation;

@MessageClassAnnotation(from = Message.NodeType.LOGIN, to = Message.NodeType.GATE, desc = "转发")
public class ForwardLoginToGate {
  static class Request {
    @MessageFieldAnnotation(desc = "channel id")
    String channelID;

    @MessageFieldAnnotation(desc = "关闭channel的原因，没有则不关闭")
    String closeReason;

    @MessageFieldAnnotation(desc = "消息")
    byte[] msg;
  }
}
