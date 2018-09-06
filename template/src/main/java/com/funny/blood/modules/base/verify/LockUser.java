package com.funny.blood.modules.base.verify;

import shell.net.Message;
import shell.tool.message.MessageClassAnnotation;
import shell.tool.message.MessageFieldAnnotation;

@MessageClassAnnotation(
    from = Message.NodeType.LOGIN,
    to = Message.NodeType.GATE,
    desc = "绑定channel和账号")
public class LockUser {
  static class Request {
    @MessageFieldAnnotation(desc = "channel id")
    String channelID;

    @MessageFieldAnnotation(desc = "用户ID")
    int userID;
  }
}
