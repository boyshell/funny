package com.funny.blood.modules.base.room;

import com.funny.blood.modules.base.room.RoomServerBean;
import shell.net.Message;
import shell.tool.message.MessageClassAnnotation;
import shell.tool.message.MessageFieldAnnotation;

@MessageClassAnnotation(from = Message.NodeType.HALL, to = Message.NodeType.GATE, desc = "添加房间")
public class AddRoom {
  static class Request {
    @MessageFieldAnnotation(desc = "房间服务器")
    RoomServerBean server;
  }
}
