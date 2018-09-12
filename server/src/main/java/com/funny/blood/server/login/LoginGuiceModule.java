package com.funny.blood.server.login;

import com.funny.blood.GameGuiceModule;
import com.funny.blood.db.DBPool;
import com.funny.blood.db.IDBProperties;
import com.funny.blood.modules.ClientToLoginMessageGroup;
import com.funny.blood.modules.GateToLoginMessageGroup;
import com.funny.blood.modules.user.login.UserInLoginDataSet;
import com.funny.blood.server.login.net.GateToLoginDispatcher;
import com.funny.blood.server.login.net.LoginServer;
import com.funny.blood.AbstractShutdownHooks;

public class LoginGuiceModule extends GameGuiceModule {
  @Override
  protected void bind() {
    bindSingleton(AbstractShutdownHooks.class, LoginShutdownHooks.class);
    bindSingleton(IDBProperties.class, LoginProperties.class);
    bindSingleton(LoginServer.class);
    bindSingleton(LoginScriptHolder.class);
    bindSingleton(GateToLoginMessageGroup.class);
    bindSingleton(GateToLoginDispatcher.class);
    bindSingleton(LoginProperties.class);
    bindSingleton(ClientToLoginMessageGroup.class);
    bindSingleton(UserInLoginDataSet.class);
    bindSingleton(DBPool.class);
  }
}
