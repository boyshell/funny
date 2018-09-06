package com.funny.blood.modules.poker;

/** 点数 */
public enum Rank {
  /** A */
  RANK_ACE(1),
  /** 2 */
  RANK_2(2),
  /** 3 */
  RANK_3(3),
  /** 4 */
  RANK_4(4),
  /** 5 */
  RANK_5(5),
  /** 6 */
  RANK_6(6),
  /** 7 */
  RANK_7(7),
  /** 8 */
  RANK_8(8),
  /** 9 */
  RANK_9(9),
  /** 10 */
  RANK_10(10),
  /** J */
  RANK_J(11),
  /** Q */
  RANK_Q(12),
  /** K */
  RANK_K(13),
  /** 小鬼 */
  RANK_BLACK_JOKER(14),
  /** 大鬼 */
  RANK_COLOR_JOKER(15),
  ;
  private final int value;

  Rank(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public static Rank valueOf(int value) {
    switch (value) {
      case 1:
        /** A */
        return RANK_ACE;
      case 2:
        /** 2 */
        return RANK_2;
      case 3:
        /** 3 */
        return RANK_3;
      case 4:
        /** 4 */
        return RANK_4;
      case 5:
        /** 5 */
        return RANK_5;
      case 6:
        /** 6 */
        return RANK_6;
      case 7:
        /** 7 */
        return RANK_7;
      case 8:
        /** 8 */
        return RANK_8;
      case 9:
        /** 9 */
        return RANK_9;
      case 10:
        /** 10 */
        return RANK_10;
      case 11:
        /** J */
        return RANK_J;
      case 12:
        /** Q */
        return RANK_Q;
      case 13:
        /** K */
        return RANK_K;
      case 14:
        /** 小鬼 */
        return RANK_BLACK_JOKER;
      case 15:
        /** 大鬼 */
        return RANK_COLOR_JOKER;
    }
    return null;
  }
}