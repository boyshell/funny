package com.funny.blood.net;

import com.google.common.collect.ImmutableMap;
import shell.net.Message;
import shell.net.MessageFactory;

/** Created by zhangxiangxi on 17-7-24. */
public abstract class MessageGroup extends MessageFactory {
  private final ImmutableMap<Integer, Class<? extends Message>> messages;

  public MessageGroup(ImmutableMap<Integer, Class<? extends Message>>... group) {
    ImmutableMap.Builder<Integer, Class<? extends Message>> builder = ImmutableMap.builder();
    for (ImmutableMap<Integer, Class<? extends Message>> map : group) {
      builder.putAll(map);
    }
    messages = builder.build();
  }

  @Override
  protected Class<? extends Message> getClass(int id) {
    return messages.get(id);
  }
}
