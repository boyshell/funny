package com.funny.blood.properties;

import com.funny.blood.modules.base.room.GameType;
import com.google.inject.Inject;
import shell.io.FileUtil;
import shell.io.Properties;

import java.io.IOException;

public class RoomProperties {
  public final GameType GAME_TYPE;
  public final int ID;
  public final String HOST;
  public final int PORT;
  public final String HALL_HOST;
  public final int HALL_PORT;
  public final int MAX;
  public final int NEED_CHIP;

  @Inject
  public RoomProperties() throws IOException {
    Properties properties = FileUtil.newProperties("room.properties");
    this.GAME_TYPE = GameType.valueOf(properties.getProperty("game_type"));
    this.ID = properties.getInt("id");
    this.HOST = properties.getProperty("host");
    this.PORT = properties.getInt("port");
    this.HALL_HOST = properties.getProperty("hall_host");
    this.HALL_PORT = properties.getInt("hall_port");
    this.MAX = properties.getInt("max");
    this.NEED_CHIP = properties.getInt("need_chip");
  }
}
