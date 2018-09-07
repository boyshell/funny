package com.funny.blood.modules.poker.ddz;

import shell.net.Message;
import shell.tool.message.MessageClassAnnotation;
import shell.tool.message.MessageFieldAnnotation;

@MessageClassAnnotation(from = Message.NodeType.ROOM, to = Message.NodeType.CLIENT, desc = "测试")
public class Test1 {
  static class Request {
    @MessageFieldAnnotation(desc = "服务器")
    short server;

    @MessageFieldAnnotation(desc = "帐号")
    String account;

    @MessageFieldAnnotation(desc = "是否成年")
    boolean adult;

    @MessageFieldAnnotation(desc = "时间戳")
    int timestamp;

    @MessageFieldAnnotation(desc = "MD5")
    String md5;

    @MessageFieldAnnotation(desc = "显示器宽(像素)")
    short screenWidth;

    @MessageFieldAnnotation(desc = "显示器高(像素)")
    short screenHeight;

    @MessageFieldAnnotation(desc = "前端unix时间戳")
    long time;
  }
}
