package com.funny.blood.modules;


import com.google.common.collect.ImmutableMap;
import shell.net.Message;
import shell.net.MessageFactory;

public class LoginToGateMessageGroup extends MessageFactory {
  public final ImmutableMap<Integer, Class<? extends Message>> messages;

  public LoginToGateMessageGroup() {
    ImmutableMap.Builder<Integer, Class<? extends Message>> builder = ImmutableMap.builder();
    builder.put(14, com.funny.blood.modules.base.net.ForwardLoginToGateRequest.class);
    messages = builder.build();
  }

  @Override
  protected Class<? extends Message> getClass(int id) {
    return messages.get(id);
  }
}
