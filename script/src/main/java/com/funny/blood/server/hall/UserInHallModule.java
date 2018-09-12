package com.funny.blood.server.hall;

import com.funny.blood.db.DBPool;
import com.funny.blood.modules.base.login.ValueType;
import com.funny.blood.modules.user.hall.UserInHall;
import com.funny.blood.modules.user.hall.UserInHallDataSet;
import com.funny.blood.server.UserModule;
import com.funny.blood.server.hall.worker.HallWorkerDataSet;
import com.funny.blood.server.hall.worker.UserInHallTask;
import com.funny.blood.woker.WeightWorker;
import com.google.inject.Inject;

public class UserInHallModule extends UserModule {
  private final UserInHallDataSet dataSet;
  private final HallWorkerDataSet hallWorkerDataSet;

  @Inject
  public UserInHallModule(
      UserInHallDataSet dataSet, DBPool dbPool, HallWorkerDataSet hallWorkerDataSet) {
    super(dbPool);
    this.dataSet = dataSet;
    this.hallWorkerDataSet = hallWorkerDataSet;
  }

  // todo 做成lru cache, user.getLastActiveTime()进行判定
  public void exec(int userID, UserInHallTask task) {
    UserInHall user = dataSet.getUsers().get(userID);
    if (user == null) {
      UserInHall newUser = new UserInHall(userID, selectWorker());
      user = dataSet.getUsers().putIfAbsent(userID, newUser);
      if (user == null) {
        // 从数据库初始化
        user = newUser;
        user.getWorker().borrow(); // todo 删除user之后需要giveback
        user.getValues().set(ValueType.CHIP, getChip(userID));
      }
    }
    user.getWorker().execute(user, task);
  }

  private WeightWorker selectWorker() {
    int weight = Integer.MAX_VALUE;
    WeightWorker worker = null;
    for (WeightWorker tmp : hallWorkerDataSet.getWorkers()) {
      if (tmp.getWeight() < weight) {
        worker = tmp;
        weight = tmp.getWeight();
      }
    }
    return worker;
  }
}
