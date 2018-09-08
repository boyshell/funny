package com.funny.blood.modules.user.hall;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserInHallDataSet {
  private final Map<Integer, UserInHall> users = new ConcurrentHashMap<>();

  public Map<Integer, UserInHall> getUsers() {
    return users;
  }
}
