package com.funny.blood.modules.poker.zjh;


import io.netty.buffer.ByteBuf;
import shell.net.Message;
import shell.nio.ByteBufUtil;

import javax.annotation.Nullable;

import static shell.net.Message.NodeType.GAME;
import static shell.net.Message.NodeType.CLIENT;

/** 炸金花发牌 */
public class ZJHDealRequest implements Message {
  public ZJHDealRequest() {}

  public ZJHDealRequest(java.util.List<com.funny.blood.modules.poker.CardBean> cards) {
    this.cards = cards;
  }

  /** 牌 */
  private java.util.List<com.funny.blood.modules.poker.CardBean> cards = new java.util.ArrayList<>();

  /** 牌 */
  public ZJHDealRequest setCards(java.util.List<com.funny.blood.modules.poker.CardBean> cards) {
    this.cards = cards;
    return this;
  }

  /** 牌 */
  public java.util.List<com.funny.blood.modules.poker.CardBean> getCards() {
    return this.cards;
  }

  @Override
  public void write(ByteBuf buf) {
    ByteBufUtil.writeInt(buf, this.cards.size());
    for (com.funny.blood.modules.poker.CardBean i_am_tmp : this.cards) {
      i_am_tmp.write(buf);
    }
  }

  @Override
  public ZJHDealRequest read(ByteBuf buf) {
    int size52413035;
    size52413035 = ByteBufUtil.readInt(buf);
    this.cards = new java.util.ArrayList(size52413035);
    for (int i_am_tmp_i = 0; i_am_tmp_i < size52413035; ++i_am_tmp_i) {
      this.cards.add(new com.funny.blood.modules.poker.CardBean().read(buf));
    }
    return this;
  }

  @Override
  public int id() {
    return 18;
  }

  @Override
  public NodeType from() {
    return GAME;
  }

  @Override
  public NodeType to() {
    return CLIENT;
  }

  @Nullable
  public Message error(int e) {
    return null;
  }
}
