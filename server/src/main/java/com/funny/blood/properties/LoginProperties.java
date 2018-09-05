package com.funny.blood.properties;

import com.google.inject.Inject;
import shell.io.FileUtil;
import shell.io.Properties;

import java.io.IOException;

public class LoginProperties {
  public final int PORT;

  @Inject
  public LoginProperties() throws IOException {
    Properties properties = FileUtil.newProperties("login.properties");

    this.PORT = properties.getInt("port");
  }
}
