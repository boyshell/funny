package com.funny.blood.properties;

import com.funny.blood.cfg.IConfigPath;
import com.google.inject.Inject;
import shell.io.FileUtil;
import shell.io.Properties;

import java.io.IOException;

public class RobotProperties implements IConfigPath {
  public final String ROBOT_NAME;
  public final int ROBOT_NUM;
  public final String GATE_HOST;
  public final int GATE_PORT;
  public final String CFG_SERVER_PATH;

  @Inject
  public RobotProperties() throws IOException {
    Properties properties = FileUtil.newProperties("robot.properties");

    ROBOT_NAME = properties.getProperty("robot_name");
    ROBOT_NUM = properties.getInt("robot_num");
    GATE_HOST = properties.getProperty("gate_host");
    GATE_PORT = properties.getInt("gate_port");
    this.CFG_SERVER_PATH = properties.getProperty("cfg_server_path");
  }

  @Override
  public String cfgServerPath() {
    return CFG_SERVER_PATH;
  }
}
