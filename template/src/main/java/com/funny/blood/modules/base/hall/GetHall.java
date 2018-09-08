package com.funny.blood.modules.base.hall;

import shell.net.Message;
import shell.tool.message.MessageClassAnnotation;
import shell.tool.message.MessageFieldAnnotation;

@MessageClassAnnotation(from = Message.NodeType.GATE, to = Message.NodeType.HALL, desc = "登录事件")
public class GetHall {
  static class Request {
    @MessageFieldAnnotation(desc = "用户ID")
    int userID;
  }

  static class Response {
    @MessageFieldAnnotation(desc = "大厅")
    HallBean hall;
  }
}
