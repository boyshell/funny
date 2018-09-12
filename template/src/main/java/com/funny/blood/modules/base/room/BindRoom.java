package com.funny.blood.modules.base.room;

import com.funny.blood.modules.base.room.GameType;
import shell.net.Message;
import shell.tool.message.MessageClassAnnotation;
import shell.tool.message.MessageFieldAnnotation;

@MessageClassAnnotation(from = Message.NodeType.HALL, to = Message.NodeType.GATE, desc = "绑定房间服务器")
public class BindRoom {
  static class Request {
    @MessageFieldAnnotation(desc = "用户ID")
    int userID;

    @MessageFieldAnnotation(desc = "游戏类型")
    GameType gameType;

    @MessageFieldAnnotation(desc = "房间编号")
    int roomID;
  }
}
