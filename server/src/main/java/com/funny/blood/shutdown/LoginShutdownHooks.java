package com.funny.blood.shutdown;

import com.funny.blood.net.login.LoginServer;
import com.google.inject.Inject;

public class LoginShutdownHooks extends AbstractShutdownHooks {
  private final LoginServer loginServer;

  @Inject
  public LoginShutdownHooks(LoginServer loginServer) {
    this.loginServer = loginServer;
  }

  @Override
  protected void shutdown() {
    shutdown(() -> loginServer.shutdown(), "shutdown login server");
  }
}
