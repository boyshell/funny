package com.funny.blood.net;

import io.netty.channel.Channel;
import shell.net.Message;
import shell.net.NetUtil;

public class CommonChannel {
  private final Channel channel;

  public CommonChannel(Channel channel) {
    this.channel = channel;
  }

  public Channel getChannel() {
    return channel;
  }

  public boolean write(Message message) {
    if (!channel.isActive()) {
      return false;
    }
    NetUtil.write(channel, message);
    return true;
  }

  public boolean write(byte[] message) {
    if (!channel.isActive()) {
      return false;
    }
    NetUtil.write(channel, message);
    return true;
  }

  public boolean closeAndWrite(Message message, String because) {
    return closeAndWrite(Message.encodeToBytes(message), because);
  }

  public boolean closeAndWrite(byte[] message, String because) {
    if (!channel.isActive()) {
      return false;
    }
    NetUtil.closeAndWrite(channel, message, because);
    return true;
  }
}
