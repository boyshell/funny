package com.funny.blood.modules.base.room;

import shell.tool.message.BeanClassAnnotation;
import shell.tool.message.MessageFieldAnnotation;

@BeanClassAnnotation(desc = "房间")
public class RoomBean {
  @MessageFieldAnnotation(desc = "房间编号")
  int id;

  @MessageFieldAnnotation(desc = "人数上限")
  int max;

  @MessageFieldAnnotation(desc = "当前人数")
  int num;

  @MessageFieldAnnotation(desc = "准入筹码数量")
  int needChip;
}
