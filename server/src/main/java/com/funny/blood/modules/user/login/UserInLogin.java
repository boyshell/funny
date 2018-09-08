package com.funny.blood.modules.user.login;

import com.funny.blood.net.login.ClientToLoginUser;
import shell.util.concurrent.Door;

public class UserInLogin extends Door<ClientToLoginUser> {

  private final int id;
  private final String name;

  public UserInLogin(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
