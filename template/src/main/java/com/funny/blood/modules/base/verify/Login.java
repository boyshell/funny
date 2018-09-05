package com.funny.blood.modules.base.verify;

import shell.net.Message;
import shell.tool.message.MessageClassAnnotation;
import shell.tool.message.MessageFieldAnnotation;
import shell.tool.message.NoHandlerAnnotation;

@MessageClassAnnotation(from = Message.NodeType.CLIENT, to = Message.NodeType.GATE, desc = "登录")
public class Login {
  @NoHandlerAnnotation
  static class Request {
    @MessageFieldAnnotation(desc = "帐号")
    String account;

    @MessageFieldAnnotation(desc = "时间戳")
    int timestamp;

    @MessageFieldAnnotation(desc = "MD5")
    String md5;

    @MessageFieldAnnotation(desc = "前端unix时间戳")
    long time;
  }

  static class Response {
    @MessageFieldAnnotation(desc = "账号ID")
    long userID;

    @MessageFieldAnnotation(desc = "前端unix时间戳")
    long ctime;

    @MessageFieldAnnotation(desc = "后端unix时间戳")
    long stime;
  }

  enum Error {
    @MessageFieldAnnotation(desc = "帐号名称非法")
    ILLEGAL_USER_NAME,
    @MessageFieldAnnotation(desc = "主机地址非法")
    ILLEGAL_HOST,
    @MessageFieldAnnotation(desc = "MD5校验失败")
    ILLEGAL_MD5,
    @MessageFieldAnnotation(desc = "被封禁的帐号")
    FROZEN,
    @MessageFieldAnnotation(desc = "登录超时")
    OVER_TIME,
    @MessageFieldAnnotation(desc = "系统错误")
    SYSTEM,
    @MessageFieldAnnotation(desc = "发生极小概率事件,请重新登录")
    RELOGIN_PLEASE,
    @MessageFieldAnnotation(desc = "被顶号")
    REPLACE,
    @MessageFieldAnnotation(desc = "重复登录")
    DUPLICATE_LOGIN,
    ;
  }
}
