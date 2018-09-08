package com.funny.blood.shutdown;

import com.funny.blood.db.DBPool;
import com.funny.blood.net.login.LoginServer;
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
