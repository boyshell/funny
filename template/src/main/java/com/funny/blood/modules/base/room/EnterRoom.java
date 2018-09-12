package com.funny.blood.modules.base.room;

import shell.net.Message;
import shell.tool.message.MessageClassAnnotation;
import shell.tool.message.MessageFieldAnnotation;

@MessageClassAnnotation(from = Message.NodeType.CLIENT, to = Message.NodeType.HALL, desc = "进入游戏")
public class EnterRoom {
  static class Request {
    @MessageFieldAnnotation(desc = "游戏类型")
    GameType gameType;

    @MessageFieldAnnotation(desc = "房间编号")
    int roomID;
  }

  static class Response {
    @MessageFieldAnnotation(desc = "游戏类型")
    GameType gameType;

    @MessageFieldAnnotation(desc = "房间编号")
    int roomID;
  }

  enum Error {
    @MessageFieldAnnotation(desc = "在房间中")
    IN_ROOM,
    @MessageFieldAnnotation(desc = "没有房间")
    NO_ROOM,
    @MessageFieldAnnotation(desc = "房间满")
    FULL,
    @MessageFieldAnnotation(desc = "系统错误")
    SYS,
    ;
  }
}
