package com.funny.blood.woker;

public abstract class UserTask<T> {
  private final String name;

  public UserTask(String name) {
    this.name = name;
  }

  public abstract void exec(T user);

  public String getName() {
    return name;
  }
}
