package com.funny.blood.modules.base.login;

import shell.tool.message.BeanClassAnnotation;
import shell.tool.message.MessageFieldAnnotation;

@BeanClassAnnotation(desc = "值类型")
public enum ValueType {
  @MessageFieldAnnotation(desc = "筹码")
  CHIP,
}
