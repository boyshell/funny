package com.funny.blood.properties;

import com.google.inject.Inject;
import shell.io.FileUtil;
import shell.io.Properties;

import java.io.IOException;

public class GateProperties {
  public final int PORT;
  public final String LOGIN_HOST;
  public final int LOGIN_PORT;

  @Inject
  public GateProperties() throws IOException {
    Properties properties = FileUtil.newProperties("gate.properties");

    this.PORT = properties.getInt("port");
    this.LOGIN_HOST = properties.getProperty("login_host");
    this.LOGIN_PORT = properties.getInt("login_port");
  }
}
