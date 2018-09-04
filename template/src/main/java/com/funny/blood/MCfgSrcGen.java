package com.funny.blood;

import shell.tool.config.ConfigUtil;

import java.io.File;

public class MCfgSrcGen {
  private static final String EXCEL_DIR = "cfg";
  private static final String PKG = "com.funny.blood";
  private static final File SERVER_SRC_DIR = new File("server/src/main/generated");
  private static final File SERVER_CUSTOM_SRC_DIR = new File("server/src/main/java");
  private static final File CLIENT_SRC_DIR = new File("../share/src");
  private static final File CLIENT_CUSTOM_SRC_DIR = CLIENT_SRC_DIR;

  public static void main(String[] args) throws Exception {
    ConfigUtil.generate(
        EXCEL_DIR,
        PKG,
        SERVER_SRC_DIR,
        SERVER_CUSTOM_SRC_DIR,
        CLIENT_SRC_DIR,
        CLIENT_CUSTOM_SRC_DIR);
  }
}
