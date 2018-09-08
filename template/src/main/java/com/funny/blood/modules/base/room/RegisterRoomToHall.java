package com.funny.blood.modules.base.room;

import shell.net.Message;
import shell.tool.message.MessageClassAnnotation;
import shell.tool.message.MessageFieldAnnotation;

@MessageClassAnnotation(from = Message.NodeType.ROOM, to = Message.NodeType.HALL, desc = "注册房间")
public class RegisterRoomToHall {
  static class Request {
    @MessageFieldAnnotation(desc = "游戏类型")
    GameType type;

    @MessageFieldAnnotation(desc = "房间ID")
    int id;

    @MessageFieldAnnotation(desc = "主机地址")
    String host;

    @MessageFieldAnnotation(desc = "端口")
    int port;

    @MessageFieldAnnotation(desc = "人数上限")
    int max;

    @MessageFieldAnnotation(desc = "需要的筹码数量")
    int needChip;
  }
}
