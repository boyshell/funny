package com.funny.blood.modules.user.hall;

import com.funny.blood.modules.base.login.ValueType;
import com.funny.blood.modules.base.net.ForwardHallToClientRequest;
import com.funny.blood.server.hall.net.RoomToHallUser;
import com.funny.blood.woker.WeightWorker;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shell.lang.EnumArray;
import shell.net.Message;
import shell.net.NetUtil;
import shell.time.TimeUtil;

import java.lang.ref.WeakReference;

public class UserInHall {
  private static final Logger logger = LoggerFactory.getLogger(UserInHall.class);
  private final int id;
  private final EnumArray<ValueType, Integer> values = EnumArray.create(ValueType.class);
  private final WeightWorker worker;
  private long lastActiveTime = TimeUtil.millis(); // 上次活跃时间
  private WeakReference<RoomToHallUser> roomRef;

  private Channel channel;
  private Thread thread;

  public UserInHall(int id, WeightWorker worker) {
    this.id = id;
    this.worker = worker;
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

  public WeightWorker getWorker() {
    return worker;
  }

  public long getLastActiveTime() {
    return lastActiveTime;
  }

  public void setLastActiveTime(long lastActiveTime) {
    this.lastActiveTime = lastActiveTime;
  }

  public WeakReference<RoomToHallUser> getRoomRef() {
    return roomRef;
  }

  public void setRoomRef(WeakReference<RoomToHallUser> roomRef) {
    this.roomRef = roomRef;
  }

  public RoomToHallUser getRoom() {
    if (roomRef == null) {
      return null;
    }
    return roomRef.get();
  }
}
