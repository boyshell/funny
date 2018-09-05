package com.funny.blood.modules.user.login;

import com.funny.blood.net.login.ClientToLoginUser;
import shell.util.concurrent.Door;

public class User extends Door {
  private final Door<ClientToLoginUser> clientDoor = new Door<>();

  private final int id;
  private final String name;

  public User(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public Door<ClientToLoginUser> getClientDoor() {
    return clientDoor;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
