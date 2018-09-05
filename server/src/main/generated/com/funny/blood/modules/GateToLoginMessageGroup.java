package com.funny.blood.modules;


import com.google.common.collect.ImmutableMap;
import shell.net.Message;
import shell.net.MessageFactory;

public class GateToLoginMessageGroup extends MessageFactory {
  public final ImmutableMap<Integer, Class<? extends Message>> messages;

  public GateToLoginMessageGroup() {
    ImmutableMap.Builder<Integer, Class<? extends Message>> builder = ImmutableMap.builder();
    builder.put(12, com.funny.blood.modules.base.net.ForwardGateToLoginRequest.class);
    builder.put(16, com.funny.blood.modules.base.net.RemoveClientUserInLoginRequest.class);
    builder.put(13, com.funny.blood.modules.base.verify.Login0Request.class);
    messages = builder.build();
  }

  @Override
  protected Class<? extends Message> getClass(int id) {
    return messages.get(id);
  }
}
