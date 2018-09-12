package com.funny.blood.modules.base.login;

/** 获取用户ID错误码 */
public enum GetUserIDError {
  /** 系统错误 */
  SYSTEM(1),
  /** 顶号 */
  REPLACE(2),
  ;
  private final int value;

  GetUserIDError(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public static GetUserIDError valueOf(int value) {
    switch (value) {
      case 1:
        /** 系统错误 */
        return SYSTEM;
      case 2:
        /** 顶号 */
        return REPLACE;
    }
    return null;
  }
}