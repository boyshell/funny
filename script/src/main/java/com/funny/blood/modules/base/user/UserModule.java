package com.funny.blood.modules.base.user;

import com.funny.blood.db.DBPool;
import com.funny.blood.modules.user.UserRedisField;
import com.funny.blood.modules.user.login.User;
import com.funny.blood.modules.user.login.UserDataSet;
import com.google.inject.Inject;

public class UserModule {
  private final UserDataSet userDataSet;
  private final DBPool dbPool;

  @Inject
  public UserModule(UserDataSet userDataSet, DBPool dbPool) {
    this.userDataSet = userDataSet;
    this.dbPool = dbPool;
  }

  public User getUser(String username) {
    return userDataSet.getUsers().get(username);
  }

  public boolean add(User user) {
    if (userDataSet.getUsers().putIfAbsent(user.getName(), user) == null) {
      dbPool.exec(jedis -> UserRedisField.ID.set(jedis, user));
      return true;
    }
    return false;
  }
}
