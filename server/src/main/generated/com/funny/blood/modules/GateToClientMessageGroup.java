package com.funny.blood.modules;


import com.google.common.collect.ImmutableMap;
import shell.net.Message;
import shell.net.MessageFactory;

public class GateToClientMessageGroup extends MessageFactory {
  public final ImmutableMap<Integer, Class<? extends Message>> messages;

  public GateToClientMessageGroup() {
    ImmutableMap.Builder<Integer, Class<? extends Message>> builder = ImmutableMap.builder();
    builder.put(2, com.funny.blood.modules.base.login.LoginResponse.class);
    builder.put(3, com.funny.blood.modules.base.login.LoginError.class);
    builder.put(5, com.funny.blood.modules.base.login.VersionCheckResponse.class);
    builder.put(6, com.funny.blood.modules.base.login.VersionCheckError.class);
    builder.put(9, com.funny.blood.modules.base.net.KickRequest.class);
    messages = builder.build();
  }

  @Override
  protected Class<? extends Message> getClass(int id) {
    return messages.get(id);
  }
}
