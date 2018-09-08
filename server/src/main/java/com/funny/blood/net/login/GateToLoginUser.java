package com.funny.blood.net.login;

import com.funny.blood.net.CommonChannel;
import io.netty.channel.Channel;
import io.netty.util.AttributeKey;
import shell.net.NetUtil;
import shell.util.concurrent.IUser;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public class GateToLoginUser extends CommonChannel implements IUser {
  public static final AttributeKey<GateToLoginUser> KEY =
      NetUtil.createAttributeKey(GateToLoginUser.class);

  private final Thread thread;
  private final Map<String, ClientToLoginUser> clientUsers = new HashMap<>();

  public GateToLoginUser(Channel channel, Thread thread) {
    super(channel);
    this.thread = thread;
  }

  @Override
  public Thread thread() {
    return thread;
  }

  @Override
  public Executor executor() {
    return getChannel().eventLoop();
  }

  public Map<String, ClientToLoginUser> getClientUsers() {
    return clientUsers;
  }
}
