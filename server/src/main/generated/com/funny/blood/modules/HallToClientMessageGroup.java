package com.funny.blood.modules;


import com.google.common.collect.ImmutableMap;
import shell.net.Message;
import shell.net.MessageFactory;

public class HallToClientMessageGroup extends MessageFactory {
  public final ImmutableMap<Integer, Class<? extends Message>> messages;

  public HallToClientMessageGroup() {
    ImmutableMap.Builder<Integer, Class<? extends Message>> builder = ImmutableMap.builder();
    builder.put(21, com.funny.blood.modules.base.login.UpdateValueRequest.class);
    builder.put(28, com.funny.blood.modules.base.room.EnterRoomResponse.class);
    builder.put(29, com.funny.blood.modules.base.room.EnterRoomError.class);
    messages = builder.build();
  }

  @Override
  protected Class<? extends Message> getClass(int id) {
    return messages.get(id);
  }
}
