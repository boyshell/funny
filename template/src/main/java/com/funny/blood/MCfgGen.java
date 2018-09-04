package com.funny.blood;

import shell.tool.config.ConfigUtil;

import java.io.File;
import java.io.IOException;

public class MCfgGen {
  private static final String EXCEL_DIR = "cfg";
  private static final File SERVER_FILE = new File("cfg/server.bin");
  private static final File CLIENT_FILE = new File("cfg/client.bin");

  public static void main(String[] args) throws IOException {
    ConfigUtil.export(EXCEL_DIR, SERVER_FILE, CLIENT_FILE);
  }
}
