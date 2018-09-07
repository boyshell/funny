package com.funny.blood.db;

import com.google.inject.Inject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.function.Consumer;

public class DBPool {
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
}
