package com.funny.blood.modules.poker;

import io.netty.buffer.ByteBuf;
import shell.net.Bean;
import shell.nio.ByteBufUtil;

/** 牌 */
public class CardBean implements Bean<CardBean> {
  public CardBean() {}

  public CardBean(com.funny.blood.modules.poker.Suit suit, com.funny.blood.modules.poker.Rank rank) {
    this.suit = suit;
    this.rank = rank;
  }

  /** 花色[1:黑桃][2:红桃][3:方块][4:梅花] */
  private com.funny.blood.modules.poker.Suit suit;
  /** 点数[1:A][2:2][3:3][4:4][5:5][6:6][7:7][8:8][9:9][10:10][11:J][12:Q][13:K][14:小鬼][15:大鬼] */
  private com.funny.blood.modules.poker.Rank rank;

  /** 花色[1:黑桃][2:红桃][3:方块][4:梅花] */
  public CardBean setSuit(com.funny.blood.modules.poker.Suit suit) {
    this.suit = suit;
    return this;
  }

  /** 花色[1:黑桃][2:红桃][3:方块][4:梅花] */
  public com.funny.blood.modules.poker.Suit getSuit() {
    return this.suit;
  }

  /** 点数[1:A][2:2][3:3][4:4][5:5][6:6][7:7][8:8][9:9][10:10][11:J][12:Q][13:K][14:小鬼][15:大鬼] */
  public CardBean setRank(com.funny.blood.modules.poker.Rank rank) {
    this.rank = rank;
    return this;
  }

  /** 点数[1:A][2:2][3:3][4:4][5:5][6:6][7:7][8:8][9:9][10:10][11:J][12:Q][13:K][14:小鬼][15:大鬼] */
  public com.funny.blood.modules.poker.Rank getRank() {
    return this.rank;
  }

  @Override
  public void write(ByteBuf buf) {
    ByteBufUtil.writeInt(buf, this.suit != null ? this.suit.getValue() : 0);
    ByteBufUtil.writeInt(buf, this.rank != null ? this.rank.getValue() : 0);
  }

  @Override
  public CardBean read(ByteBuf buf) {
    int size52413035;
    this.suit = com.funny.blood.modules.poker.Suit.valueOf(ByteBufUtil.readInt(buf));
    this.rank = com.funny.blood.modules.poker.Rank.valueOf(ByteBufUtil.readInt(buf));
    return this;
  }
}