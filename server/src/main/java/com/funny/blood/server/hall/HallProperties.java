package com.funny.blood.server.hall;

import com.funny.blood.db.IDBProperties;
import com.google.inject.Inject;
import shell.io.FileUtil;
import shell.io.Properties;

import java.io.IOException;

public class HallProperties implements IDBProperties {
  public final int PORT;

  public final String REDIS_HOST;
  public final int REDIS_PORT;

  @Inject
  public HallProperties() throws IOException {
    Properties properties = FileUtil.newProperties("hall.properties");

    PORT = properties.getInt("port");
    REDIS_HOST = properties.getProperty("redis_host");
    REDIS_PORT = properties.getInt("redis_port");
  }

  @Override
  public String dbHost() {
    return REDIS_HOST;
  }

  @Override
  public int dbPort() {
    return REDIS_PORT;
  }
}
