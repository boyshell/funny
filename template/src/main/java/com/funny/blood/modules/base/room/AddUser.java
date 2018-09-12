package com.funny.blood.modules.base.room;

import shell.net.Message;
import shell.tool.message.MessageClassAnnotation;
import shell.tool.message.MessageFieldAnnotation;

@MessageClassAnnotation(from = Message.NodeType.HALL, to = Message.NodeType.ROOM, desc = "添加用户")
public class AddUser {
  static class Request {
    @MessageFieldAnnotation(desc = "用户ID")
    int userID;
  }

  static class Response {
    @MessageFieldAnnotation(desc = "用户ID")
    int userID;

    @MessageFieldAnnotation(desc = "是否添加成功")
    boolean suc;
  }
}
