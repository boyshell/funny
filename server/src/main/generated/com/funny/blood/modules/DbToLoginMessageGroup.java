package com.funny.blood.modules;


import com.google.common.collect.ImmutableMap;
import shell.net.Message;
import shell.net.MessageFactory;

public class DbToLoginMessageGroup extends MessageFactory {
  public final ImmutableMap<Integer, Class<? extends Message>> messages;

  public DbToLoginMessageGroup() {
    ImmutableMap.Builder<Integer, Class<? extends Message>> builder = ImmutableMap.builder();
    messages = builder.build();
  }

  @Override
  protected Class<? extends Message> getClass(int id) {
    return messages.get(id);
  }
}
