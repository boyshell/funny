package com.funny.blood.modules.base.user;

import com.funny.blood.db.DBPool;
import com.google.inject.Inject;
import redis.clients.jedis.Jedis;
import shell.lang.StringUtil;

public class UserModule {
  private final DBPool dbPool;

  @Inject
  public UserModule(DBPool dbPool) {
    this.dbPool = dbPool;
  }

  public Long newUserID() {
    try (Jedis jedis = dbPool.getJedisPool().getResource()) {
      return jedis.incr(DBPool.KEY_USER_ID);
    }
  }

  public void set(String username, int userID) {
    try (Jedis jedis = dbPool.getJedisPool().getResource()) {
      jedis.set(DBPool.KEY_USER_NAME_PREFIX + username, String.valueOf(userID));
    }
  }

  public int getChip(int userID) {
    try (Jedis jedis = dbPool.getJedisPool().getResource()) {
      String chip = jedis.get(DBPool.KEY_USER_CHIP + userID);
      if (!StringUtil.isNullOrEmpty(chip)) {
        return Integer.parseInt(chip);
      }
    }
    return 0;
  }
}
