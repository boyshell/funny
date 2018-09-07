package com.funny.blood.modules.user;

import com.funny.blood.modules.user.login.User;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

/** key为username */
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

  public static Response<String> create(Pipeline p, String key) {
    return p.hget(key, ID.name());
  }

  public void set(Jedis jedis, User user) {
    jedis.hset(user.getName(), name(), value(user));
  }

  protected abstract String value(User user);
}
