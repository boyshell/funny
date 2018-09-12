package com.funny.blood.modules.base.room;

import shell.tool.message.BeanClassAnnotation;
import shell.tool.message.MessageFieldAnnotation;

@BeanClassAnnotation(desc = "房间服务器")
public class RoomServerBean {
  @MessageFieldAnnotation(desc = "游戏类型")
  GameType gameType;

  @MessageFieldAnnotation(desc = "房间编号")
  int roomID;

  @MessageFieldAnnotation(desc = "主机地址")
  String host;

  @MessageFieldAnnotation(desc = "主机端口")
  int port;
}
