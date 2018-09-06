package com.funny.blood.modules.user.login;

import com.funny.blood.modules.user.UserRedisField;
import com.funny.blood.properties.LoginProperties;
import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import shell.time.TimeUtil;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserDataSet {
  private static final Logger logger = LoggerFactory.getLogger(UserDataSet.class);
  private final Jedis jedis;
  private final Map<String, User> users = new ConcurrentHashMap<>();

  @Inject
  public UserDataSet(LoginProperties properties) {
    this.jedis = new Jedis(properties.REDIS_HOST, properties.REDIS_PORT);
    long cost = TimeUtil.millis();
    for (String key : this.jedis.keys("*")) {
      User user = UserRedisField.create(this.jedis, key);
      users.put(user.getName(), user);
    }
    cost = TimeUtil.millis() - cost;
    logger.info("load {} user suc, cost {} ms", users.size(), cost);
  }

  public Map<String, User> getUsers() {
    return users;
  }

  public Jedis getJedis() {
    return jedis;
  }
}
