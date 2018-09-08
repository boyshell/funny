package com.funny.blood.modules.base.room;

/** 游戏类型 */
public enum GameType {
  /** 捕鱼 */
  FISH(1),
  ;
  private final int value;

  GameType(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public static GameType valueOf(int value) {
    switch (value) {
      case 1:
        /** 捕鱼 */
        return FISH;
    }
    return null;
  }
}