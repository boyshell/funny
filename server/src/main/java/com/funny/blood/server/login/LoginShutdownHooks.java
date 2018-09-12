package com.funny.blood.server.login;

import com.funny.blood.db.DBPool;
import com.funny.blood.server.login.net.LoginServer;
import com.funny.blood.AbstractShutdownHooks;
import com.google.inject.Inject;

public class LoginShutdownHooks extends AbstractShutdownHooks {
  private final LoginServer loginServer;
  private final DBPool dbPool;

  @Inject
  public LoginShutdownHooks(LoginServer loginServer, DBPool dbPool) {
    this.loginServer = loginServer;
    this.dbPool = dbPool;
  }

  @Override
  protected void shutdown() {
    shutdown(() -> loginServer.shutdown(), "shutdown login server");
    shutdown(() -> dbPool.shutdown(), "shutdown db");
  }
}
