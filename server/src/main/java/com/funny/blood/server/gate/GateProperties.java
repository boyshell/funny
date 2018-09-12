package com.funny.blood.server.gate;

import com.funny.blood.cfg.IConfigProperties;
import com.google.inject.Inject;
import shell.io.FileUtil;
import shell.io.Properties;

import java.io.IOException;

public class GateProperties implements IConfigProperties {
  public final int PORT;
  public final String LOGIN_HOST;
  public final int LOGIN_PORT;
  public final String CFG_SERVER_PATH;
  public final String HALL_HOST;
  public final int HALL_PORT;

  @Inject
  public GateProperties() throws IOException {
    Properties properties = FileUtil.newProperties("gate.properties");

    this.PORT = properties.getInt("port");
    this.LOGIN_HOST = properties.getProperty("login_host");
    this.LOGIN_PORT = properties.getInt("login_port");
    this.CFG_SERVER_PATH = properties.getProperty("cfg_server_path");
    this.HALL_HOST = properties.getProperty("hall_host");
    this.HALL_PORT = properties.getInt("hall_port");
  }

  @Override
  public String cfgServerPath() {
    return CFG_SERVER_PATH;
  }
}
