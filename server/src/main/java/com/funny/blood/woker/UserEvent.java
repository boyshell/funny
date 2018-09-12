package com.funny.blood.woker;

import shell.util.concurrent.Worker;

public class UserEvent<T> extends Worker.Event {
  private T user;
  private UserTask userTask;

  public T getUser() {
    return user;
  }

  public void setUser(T user) {
    this.user = user;
  }

  public UserTask getUserTask() {
    return userTask;
  }

  public void setUserTask(UserTask userTask) {
    this.userTask = userTask;
  }
}
