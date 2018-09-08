package com.funny.blood.modules.base.room;

import shell.tool.message.BeanClassAnnotation;
import shell.tool.message.MessageFieldAnnotation;

import java.util.List;

@BeanClassAnnotation(desc = "游戏")
public class GameBean {
  @MessageFieldAnnotation(desc = "游戏类型")
  GameType type;

  @MessageFieldAnnotation(desc = "房间列表")
  List<RoomBean> rooms;
}
