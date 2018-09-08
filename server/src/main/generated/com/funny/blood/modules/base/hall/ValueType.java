package com.funny.blood.modules.base.hall;

/** 值类型 */
public enum ValueType {
  /** 筹码 */
  CHIP(1),
  ;
  private final int value;

  ValueType(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public static ValueType valueOf(int value) {
    switch (value) {
      case 1:
        /** 筹码 */
        return CHIP;
    }
    return null;
  }
}