package com.funny.blood.modules.base.login;

import com.funny.blood.modules.base.room.GameBean;
import shell.tool.message.BeanClassAnnotation;
import shell.tool.message.MessageFieldAnnotation;

import java.util.List;

@BeanClassAnnotation(desc = "大厅")
public class HallBean {
  @MessageFieldAnnotation(desc = "用户ID")
  int userID;

  @MessageFieldAnnotation(desc = "值(参见UpdateValue)")
  List<Integer> values;

  @MessageFieldAnnotation(desc = "游戏列表")
  List<GameBean> games;
}
