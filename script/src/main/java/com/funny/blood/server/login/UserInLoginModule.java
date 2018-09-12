package com.funny.blood.server.login;

import com.funny.blood.db.DBPool;
import com.funny.blood.server.UserModule;
import com.funny.blood.modules.user.login.UserInLogin;
import com.funny.blood.modules.user.login.UserInLoginDataSet;
import com.google.inject.Inject;

public class UserInLoginModule extends UserModule {
  private final UserInLoginDataSet userDataSet;

  @Inject
  public UserInLoginModule(UserInLoginDataSet userDataSet, DBPool dbPool) {
    super(dbPool);
    this.userDataSet = userDataSet;
  }

  public UserInLogin getUser(String username) {
    return userDataSet.getUsers().get(username);
  }

  public boolean add(UserInLogin user) {
    if (userDataSet.getUsers().putIfAbsent(user.getName(), user) == null) {
      set(user.getName(), user.getId());
      return true;
    }
    return false;
  }
}
