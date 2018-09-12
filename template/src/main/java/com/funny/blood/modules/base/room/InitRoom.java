package com.funny.blood.modules.base.room;

import com.funny.blood.modules.base.room.RoomServerBean;
import shell.net.Message;
import shell.tool.message.MessageClassAnnotation;
import shell.tool.message.MessageFieldAnnotation;

import java.util.List;

@MessageClassAnnotation(from = Message.NodeType.HALL, to = Message.NodeType.GATE, desc = "初始化房间")
public class InitRoom {
  static class Request {
    @MessageFieldAnnotation(desc = "房间服务器")
    List<RoomServerBean> servers;
  }
}
