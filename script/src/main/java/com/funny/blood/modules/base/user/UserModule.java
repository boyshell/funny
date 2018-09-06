package com.funny.blood.modules.base.user;

import com.funny.blood.modules.user.UserRedisField;
import com.funny.blood.modules.user.login.User;
import com.funny.blood.modules.user.login.UserDataSet;
import com.google.inject.Inject;

public class UserModule {
  private final UserDataSet userDataSet;

  @Inject
  public UserModule(UserDataSet userDataSet) {
    this.userDataSet = userDataSet;
  }

  public User getUser(String username) {
    return userDataSet.getUsers().get(username);
  }

  public boolean add(User user) {
    if (userDataSet.getUsers().putIfAbsent(user.getName(), user) == null) {
      UserRedisField.ID.set(userDataSet.getJedis(), user);
      return true;
    }
    return false;
  }
}
