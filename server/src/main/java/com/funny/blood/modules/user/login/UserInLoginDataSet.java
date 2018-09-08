package com.funny.blood.modules.user.login;

import com.funny.blood.db.DBPool;
import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Pipeline;
import shell.time.TimeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserInLoginDataSet {
  private static final Logger logger = LoggerFactory.getLogger(UserInLoginDataSet.class);

  private final Map<String, UserInLogin> users = new ConcurrentHashMap<>();

  @Inject
  public UserInLoginDataSet(DBPool dbPool) {
    dbPool.exec(
        jedis -> {
          long cost = TimeUtil.millis();
          Pipeline p = jedis.pipelined();
          List<String> names = new ArrayList<>();
          for (String key : jedis.keys(DBPool.KEY_USER_NAME_PREFIX + "*")) {
            p.get(key);
            names.add(key);
          }
          List<Object> ids = p.syncAndReturnAll();
          for (int i = 0; i < ids.size(); ++i) {
            users.put(
                names.get(i), new UserInLogin(Integer.parseInt((String) ids.get(i)), names.get(i)));
          }
          cost = TimeUtil.millis() - cost;
          logger.info("load {} user suc, cost {} ms", users.size(), cost);
        });
  }

  public Map<String, UserInLogin> getUsers() {
    return users;
  }
}
