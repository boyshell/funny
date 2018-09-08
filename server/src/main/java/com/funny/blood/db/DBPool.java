package com.funny.blood.db;

import com.google.inject.Inject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.function.Consumer;

public class DBPool {
  public static final String KEY_USER_ID = "USER_ID_";
  public static final String KEY_USER_NAME_PREFIX = "UNAME_";
  public static final String KEY_USER_CHIP = "USER_CHIP_";

  private final JedisPool jedisPool;

  @Inject
  public DBPool(IDBProperties properties) {
    this.jedisPool = new JedisPool(properties.dbHost(), properties.dbPort());
  }

  public void exec(Consumer<Jedis> action) {
    try (Jedis jedis = jedisPool.getResource()) {
      action.accept(jedis);
    }
  }

  public void shutdown() {
    jedisPool.close();
  }

  public JedisPool getJedisPool() {
    return jedisPool;
  }
}
