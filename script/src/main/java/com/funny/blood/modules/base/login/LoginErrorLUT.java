package com.funny.blood.modules.base.login;

public enum LoginErrorLUT {
  E_SYSTEM(LoginError.SYSTEM, "系统错误"),
  E_REPLACE(LoginError.REPLACE, "顶号"),
  ;
  public final byte[] errMSG;
  public final String errStr;

  LoginErrorLUT(byte[] errMSG, String errStr) {
    this.errMSG = errMSG;
    this.errStr = errStr;
  }

  public static LoginErrorLUT valueOf(GetUserIDError error) {
    if (error == null) {
      return null;
    }
    switch (error) {
      case SYSTEM:
        return E_SYSTEM;
      case REPLACE:
        return E_REPLACE;
    }
    return null;
  }
}
