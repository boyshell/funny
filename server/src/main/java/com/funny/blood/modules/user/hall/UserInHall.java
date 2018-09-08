package com.funny.blood.modules.user.hall;

import com.funny.blood.modules.base.hall.ValueType;
import com.funny.blood.modules.base.net.ForwardHallToClientRequest;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shell.lang.EnumArray;
import shell.net.Message;
import shell.net.NetUtil;

public class UserInHall {
  private static final Logger logger = LoggerFactory.getLogger(UserInHall.class);
  private final int id;
  private final EnumArray<ValueType, Integer> values = EnumArray.create(ValueType.class);

  private Channel channel;
  private Thread thread;

  public UserInHall(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public EnumArray<ValueType, Integer> getValues() {
    return values;
  }

  public Channel getChannel() {
    return channel;
  }

  public void setChannelAndThread(Channel channel, Thread thread) {
    this.channel = channel;
    this.thread = thread;
  }

  public void write(Message message) {
    write(Message.encodeToBytes(message));
  }

  public void write(byte[] message) {
    if (thread == null) {
      return;
    }
    if (channel == null) {
      return;
    }
    if (Thread.currentThread() != thread) {
      logger.error(
          "write not in self thread!{},{}",
          thread.getName(),
          Thread.currentThread().getName(),
          new IllegalArgumentException());
      return;
    }
    NetUtil.write(channel, new ForwardHallToClientRequest(id, message));
  }
}
