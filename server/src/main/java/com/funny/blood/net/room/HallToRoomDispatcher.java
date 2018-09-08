package com.funny.blood.net.room;

import com.funny.blood.net.AbstractDispatcher;
import com.funny.blood.net.IDispatcherScript;
import com.funny.blood.script.RoomScript;
import com.google.inject.Inject;
import io.netty.channel.Channel;

import java.util.Set;

public class HallToRoomDispatcher extends AbstractDispatcher {
  private final RoomScript script;

  private static final ThreadLocal<Set<Channel>> localChannels = new ThreadLocal<>();

  @Inject
  public HallToRoomDispatcher(RoomScript script) {
    super("hall-to-room-dispatcher", null);
    this.script = script;
  }

  @Override
  protected IDispatcherScript script() {
    return script.hallToRoomDispatcher;
  }

  @Override
  protected ThreadLocal<Set<Channel>> localChannels() {
    return localChannels;
  }
}
