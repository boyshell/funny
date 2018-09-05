package com.funny.blood.modules;


import com.google.common.collect.ImmutableMap;
import shell.net.Message;
import shell.net.MessageFactory;

public class GateToGameMessageGroup extends MessageFactory {
  public final ImmutableMap<Integer, Class<? extends Message>> messages;

  public GateToGameMessageGroup() {
    ImmutableMap.Builder<Integer, Class<? extends Message>> builder = ImmutableMap.builder();
    builder.put(10, com.funny.blood.modules.base.net.ForwardGateToGameRequest.class);
    messages = builder.build();
  }

  @Override
  protected Class<? extends Message> getClass(int id) {
    return messages.get(id);
  }
}
