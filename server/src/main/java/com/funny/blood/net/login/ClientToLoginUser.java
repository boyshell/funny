package com.funny.blood.net.login;

import com.funny.blood.modules.base.net.ForwardLoginToGateRequest;
import com.funny.blood.modules.user.login.User;
import com.funny.blood.net.CommonChannel;
import io.netty.channel.Channel;
import shell.net.Message;
import shell.util.concurrent.IUser;

import javax.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

public class ClientToLoginUser extends CommonChannel implements IUser {
  private final Thread thread;
  private final String channelID;
  private final WeakReference<User> userRef;

  public ClientToLoginUser(
      Channel channel, Thread thread, String channelID, WeakReference<User> userRef) {
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

  public boolean forward(Message message) {
    return forward(message, null);
  }

  private boolean forward(Message message, @Nullable String because) {
    return forward(Message.encodeToBytes(message), because);
  }

  private boolean forward(byte[] message, @Nullable String because) {
    return write(new ForwardLoginToGateRequest(channelID, because, message));
  }

  public boolean closeAndForward(byte[] msg, String because) {
    return forward(msg, because);
  }

  public boolean closeAndForward(Message msg, String because) {
    return closeAndForward(Message.encodeToBytes(msg), because);
  }

  public WeakReference<User> getUserRef() {
    return userRef;
  }
}
