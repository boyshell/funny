package com.funny.blood;

import shell.util.JarClassLoader;

import java.io.IOException;

public abstract class Main {
  public static void main(String[] args) throws Exception {
    CmdParams params = new CmdParams(args);
    Main main = createMain(params.getScriptPath());
    main.start(params);
  }

  public abstract void start(CmdParams params) throws Exception;

  private static Main createMain(String scriptPath)
      throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
    JarClassLoader classLoader = new JarClassLoader(scriptPath);
    Class<Main> clazz = (Class<Main>) classLoader.loadClass("com.funny.blood.ScriptMain");
    return clazz.newInstance();
  }
}
