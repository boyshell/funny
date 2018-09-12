package com.funny.blood.modules.user.room;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserInRoomDataSet {
  private final Map<Integer, UserInRoom> users = new ConcurrentHashMap<>();

  public Map<Integer, UserInRoom> getUsers() {
    return users;
  }
}
