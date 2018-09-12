package com.funny.blood.modules.base.room;

import com.funny.blood.modules.base.room.GameType;
import shell.net.Message;
import shell.tool.message.MessageClassAnnotation;
import shell.tool.message.MessageFieldAnnotation;

@MessageClassAnnotation(from = Message.NodeType.HALL, to = Message.NodeType.GATE, desc = "移除房间")
public class RemoveRoom {
  static class Request {
    @MessageFieldAnnotation(desc = "房间服务器")
    GameType gameType;

    @MessageFieldAnnotation(desc = "房间ID")
    int roomID;
  }
}
