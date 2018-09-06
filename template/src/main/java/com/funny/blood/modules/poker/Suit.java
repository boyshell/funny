package com.funny.blood.modules.poker;

import shell.tool.message.BeanClassAnnotation;
import shell.tool.message.MessageFieldAnnotation;

@BeanClassAnnotation(desc = "花色")
public enum Suit {
  @MessageFieldAnnotation(desc = "黑桃")
  SPADE,
  @MessageFieldAnnotation(desc = "红桃")
  HEART,
  @MessageFieldAnnotation(desc = "方块")
  DIAMOND,
  @MessageFieldAnnotation(desc = "梅花")
  CLUB,
}
