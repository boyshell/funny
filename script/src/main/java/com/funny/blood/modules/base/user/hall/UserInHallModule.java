package com.funny.blood.modules.base.user.hall;

import com.funny.blood.db.DBPool;
import com.funny.blood.modules.base.hall.ValueType;
import com.funny.blood.modules.base.user.UserModule;
import com.funny.blood.modules.user.hall.UserInHall;
import com.funny.blood.modules.user.hall.UserInHallDataSet;
import com.google.inject.Inject;

import java.util.function.Consumer;

public class UserInHallModule extends UserModule {
  private final UserInHallDataSet dataSet;

  @Inject
  public UserInHallModule(UserInHallDataSet dataSet, DBPool dbPool) {
    super(dbPool);
    this.dataSet = dataSet;
  }

  // todo 做成lru cache
  public void exec(int userID, Consumer<UserInHall> action) {
    UserInHall user = dataSet.getUsers().get(userID);
    if (user == null) {
      UserInHall newUser = new UserInHall(userID);
      user = dataSet.getUsers().putIfAbsent(userID, newUser);
      if (user == null) {
        // 从数据库初始化
        user = newUser;
        user.getValues().set(ValueType.CHIP, getChip(userID));
      }
    }
    action.accept(user);
  }
}
