package com.funny.blood.modules.base.login;

import shell.net.Message;
import shell.tool.message.MessageClassAnnotation;
import shell.tool.message.MessageFieldAnnotation;

@MessageClassAnnotation(from = Message.NodeType.GATE, to = Message.NodeType.LOGIN, desc = "获取用户ID")
public class GetUserID {
  static class Request {
    @MessageFieldAnnotation(desc = "channel id")
    String channelID;

    @MessageFieldAnnotation(desc = "帐号")
    String account;
  }

  static class Response {
    @MessageFieldAnnotation(desc = "channel id")
    String channelID;

    @MessageFieldAnnotation(desc = "账号ID")
    int userID;

    @MessageFieldAnnotation(desc = "错误码")
    GetUserIDError error;
  }
}
