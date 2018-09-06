package com.funny.blood.modules.poker;

import shell.tool.message.BeanClassAnnotation;
import shell.tool.message.MessageFieldAnnotation;

@BeanClassAnnotation(desc = "点数")
public enum Rank {
  @MessageFieldAnnotation(desc = "A")
  RANK_ACE,
  @MessageFieldAnnotation(desc = "2")
  RANK_2,
  @MessageFieldAnnotation(desc = "3")
  RANK_3,
  @MessageFieldAnnotation(desc = "4")
  RANK_4,
  @MessageFieldAnnotation(desc = "5")
  RANK_5,
  @MessageFieldAnnotation(desc = "6")
  RANK_6,
  @MessageFieldAnnotation(desc = "7")
  RANK_7,
  @MessageFieldAnnotation(desc = "8")
  RANK_8,
  @MessageFieldAnnotation(desc = "9")
  RANK_9,
  @MessageFieldAnnotation(desc = "10")
  RANK_10,
  @MessageFieldAnnotation(desc = "J")
  RANK_J,
  @MessageFieldAnnotation(desc = "Q")
  RANK_Q,
  @MessageFieldAnnotation(desc = "K")
  RANK_K,
  @MessageFieldAnnotation(desc = "小鬼")
  RANK_BLACK_JOKER,
  @MessageFieldAnnotation(desc = "大鬼")
  RANK_COLOR_JOKER,
}
