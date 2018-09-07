package com.funny.blood.modules.poker.zjh;

import com.funny.blood.modules.poker.CardBean;
import shell.net.Message;
import shell.tool.message.MessageClassAnnotation;
import shell.tool.message.MessageFieldAnnotation;

import java.util.List;

@MessageClassAnnotation(from = Message.NodeType.ROOM, to = Message.NodeType.CLIENT, desc = "炸金花发牌")
public class ZJHDeal {
  static class Request {
    @MessageFieldAnnotation(desc = "牌")
    List<CardBean> cards;
  }
}
