package com.funny.blood;

import shell.tool.message.MessageUtil;

import java.io.File;

public class MMsgSrcGen {
  private static final ClassLoader CLASS_LOADER = MMsgSrcGen.class.getClassLoader();
  private static final String PKG = "com.funny.blood.modules";
  private static final File ID_FILE = new File("template/src/main/resources/msg-id.txt");
  private static final File SERVER_CUSTOM_SRC_DIR = new File("script/src/main/java");
  private static final File SERVER_SRC_DIR = new File("server/src/main/generated");
  private static final File CLIENT_CUSTOM_SRC_DIR = new File("../share/src");
  private static final File CLIENT_SRC_DIR = CLIENT_CUSTOM_SRC_DIR;

  public static void main(String[] args) throws Exception {
    MessageUtil.generate(
        CLASS_LOADER,
        PKG,
        ID_FILE,
        SERVER_CUSTOM_SRC_DIR,
        SERVER_SRC_DIR,
        CLIENT_CUSTOM_SRC_DIR,
        CLIENT_SRC_DIR);
  }
}
