package com.funny.blood.modules.user.login;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class UserDataSetTest {
  private final Jedis jedis = new Jedis("192.168.0.200", 6379);
  private final int num = 1000;
  private final String nameFiled = "name";
  private final String dataField = "data";

  @Test
  public void write() {
    for (int i = 0; i < num; ++i) {
      jedis.hset(key(i), nameFiled, "name" + i);
      jedis.hset(key(i), dataField, "data" + i);
    }
  }

  private String key(int index) {
    return String.valueOf(index);
  }

  @Test
  public void all() {
    for (String hkey : jedis.keys("*")) {
      System.out.println(
          "hkey:"
              + hkey
              + ",name:"
              + jedis.hget(hkey, nameFiled)
              + ",data:"
              + jedis.hget(hkey, dataField));
      jedis.del(hkey);
    }
  }
}
