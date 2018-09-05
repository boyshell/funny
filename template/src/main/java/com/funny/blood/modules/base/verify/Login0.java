package com.funny.blood.modules.base.verify;

import shell.net.Message;
import shell.tool.message.MessageClassAnnotation;
import shell.tool.message.MessageFieldAnnotation;

@MessageClassAnnotation(from = Message.NodeType.GATE, to = Message.NodeType.LOGIN, desc = "登录")
public class Login0 {
  static class Request {
    @MessageFieldAnnotation(desc = "channel id")
    String channelID;

    @MessageFieldAnnotation(desc = "帐号")
    String account;

    @MessageFieldAnnotation(desc = "时间戳")
    int timestamp;

    @MessageFieldAnnotation(desc = "MD5")
    String md5;

    @MessageFieldAnnotation(desc = "前端unix时间戳")
    long time;
  }
}
