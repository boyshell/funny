package com.funny.blood.modules.base.net;

import shell.tool.message.BeanClassAnnotation;
import shell.tool.message.MessageFieldAnnotation;

@BeanClassAnnotation(desc = "踢人类型")
public enum KickType {
  @MessageFieldAnnotation(desc = "版本不一致")
  VERSION_ILLEGAL,
  @MessageFieldAnnotation(desc = "验证未通过")
  NOT_VERIFY,
  @MessageFieldAnnotation(desc = "多次发送登录消息")
  LOGIN_MULTI_TIMES,
  @MessageFieldAnnotation(desc = "顶号")
  REPLACE,
  @MessageFieldAnnotation(desc = "流程错误")
  FLOW,
  @MessageFieldAnnotation(desc = "非法消息")
  ILLEGAL_MSG,
}
