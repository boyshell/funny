package com.funny.blood.server.room.net;

import com.funny.blood.net.AbstractDispatcher;
import com.funny.blood.net.IDispatcherScript;
import com.funny.blood.server.room.RoomScriptHolder;
import com.google.inject.Inject;
import io.netty.channel.Channel;

import java.util.Set;

public class HallToRoomDispatcher extends AbstractDispatcher {
  private final RoomScriptHolder script;

  private static final ThreadLocal<Set<Channel>> localChannels = new ThreadLocal<>();

  @Inject
  public HallToRoomDispatcher(RoomScriptHolder script) {
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
