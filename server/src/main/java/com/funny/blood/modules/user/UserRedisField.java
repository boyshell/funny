package com.funny.blood.modules.user;

import com.funny.blood.modules.user.login.User;
import redis.clients.jedis.Jedis;

public enum UserRedisField {
  ID {
    @Override
    protected String value(User user) {
      return String.valueOf(user.getId());
    }
  },
  DATA {
    @Override
    protected String value(User user) {
      throw new UnsupportedOperationException();
    }
  },
  ;

  public static User create(Jedis jedis, String key) {
    String id = jedis.hget(key, ID.name());
    return new User(Integer.parseInt(id), key);
  }

  public void set(Jedis jedis, User user) {
    jedis.hset(user.getName(), name(), value(user));
  }

  protected abstract String value(User user);
}
