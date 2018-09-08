package com.funny.blood.modules.base.verify;

import shell.tool.message.BeanClassAnnotation;
import shell.tool.message.MessageFieldAnnotation;

@BeanClassAnnotation(desc = "获取用户ID错误码")
public enum GetUserIDError {
  @MessageFieldAnnotation(desc = "系统错误")
  SYSTEM,
  @MessageFieldAnnotation(desc = "顶号")
  REPLACE,
}
