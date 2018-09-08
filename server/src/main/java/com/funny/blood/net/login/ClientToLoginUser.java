package com.funny.blood.net.login;

import com.funny.blood.modules.user.login.UserInLogin;
import com.funny.blood.net.CommonChannel;
import io.netty.channel.Channel;
import shell.util.concurrent.IUser;

import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

public class ClientToLoginUser extends CommonChannel implements IUser {
  private final Thread thread;
  private final String channelID;
  private final WeakReference<UserInLogin> userRef;

  public ClientToLoginUser(
      Channel channel, Thread thread, String channelID, WeakReference<UserInLogin> userRef) {
    super(channel);
    this.thread = thread;
    this.channelID = channelID;
    this.userRef = userRef;
  }

  @Override
  public Thread thread() {
    return thread;
  }

  @Override
  public Executor executor() {
    return getChannel().eventLoop();
  }

  public WeakReference<UserInLogin> getUserRef() {
    return userRef;
  }
}
