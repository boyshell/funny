package com.funny.blood.modules.base.user;

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
    // todo 是否需要存放全部的user?
    return userDataSet.getUsers().get(username);
  }

  public boolean add(User user) {
    return userDataSet.getUsers().putIfAbsent(user.getName(), user) == null;
  }
}
