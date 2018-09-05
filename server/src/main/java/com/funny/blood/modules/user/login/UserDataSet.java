package com.funny.blood.modules.user.login;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserDataSet {
  private final Map<String, User> users = new ConcurrentHashMap<>();

  public Map<String, User> getUsers() {
    return users;
  }
}
