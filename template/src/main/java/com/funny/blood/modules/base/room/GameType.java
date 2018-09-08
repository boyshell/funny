package com.funny.blood.modules.base.room;

import shell.tool.message.BeanClassAnnotation;
import shell.tool.message.MessageFieldAnnotation;

@BeanClassAnnotation(desc = "游戏类型")
public enum GameType {
  @MessageFieldAnnotation(desc = "捕鱼")
  FISH,
}
