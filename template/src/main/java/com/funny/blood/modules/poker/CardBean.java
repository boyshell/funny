package com.funny.blood.modules.poker;

import shell.tool.message.BeanClassAnnotation;
import shell.tool.message.MessageFieldAnnotation;

@BeanClassAnnotation(desc = "牌")
public class CardBean {
  @MessageFieldAnnotation(desc = "花色")
  Suit suit;

  @MessageFieldAnnotation(desc = "点数")
  Rank rank;
}
