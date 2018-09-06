package com.funny.blood.modules.poker;

/** 花色 */
public enum Suit {
  /** 黑桃 */
  SPADE(1),
  /** 红桃 */
  HEART(2),
  /** 方块 */
  DIAMOND(3),
  /** 梅花 */
  CLUB(4),
  ;
  private final int value;

  Suit(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public static Suit valueOf(int value) {
    switch (value) {
      case 1:
        /** 黑桃 */
        return SPADE;
      case 2:
        /** 红桃 */
        return HEART;
      case 3:
        /** 方块 */
        return DIAMOND;
      case 4:
        /** 梅花 */
        return CLUB;
    }
    return null;
  }
}