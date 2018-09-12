package com.funny.blood.modules;


import com.google.common.collect.ImmutableMap;
import shell.net.Message;
import shell.net.MessageFactory;

public class HallToGateMessageGroup extends MessageFactory {
  public final ImmutableMap<Integer, Class<? extends Message>> messages;

  public HallToGateMessageGroup() {
    ImmutableMap.Builder<Integer, Class<? extends Message>> builder = ImmutableMap.builder();
    builder.put(24, com.funny.blood.modules.base.login.GetHallResponse.class);
    builder.put(22, com.funny.blood.modules.base.net.ForwardHallToClientRequest.class);
    builder.put(33, com.funny.blood.modules.base.room.AddRoomRequest.class);
    builder.put(36, com.funny.blood.modules.base.room.BindRoomRequest.class);
    builder.put(34, com.funny.blood.modules.base.room.InitRoomRequest.class);
    builder.put(35, com.funny.blood.modules.base.room.RemoveRoomRequest.class);
    messages = builder.build();
  }

  @Override
  protected Class<? extends Message> getClass(int id) {
    return messages.get(id);
  }
}
