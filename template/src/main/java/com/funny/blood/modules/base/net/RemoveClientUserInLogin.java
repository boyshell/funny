package com.funny.blood.modules.base.net;

import shell.net.Message;
import shell.tool.message.MessageClassAnnotation;
import shell.tool.message.MessageFieldAnnotation;

@MessageClassAnnotation(
    from = Message.NodeType.GATE,
    to = Message.NodeType.LOGIN,
    desc = "在login服务器移除一个client的用户")
public class RemoveClientUserInLogin {
  static class Request {
    @MessageFieldAnnotation(desc = "channel id")
    String channelID;
  }
}
