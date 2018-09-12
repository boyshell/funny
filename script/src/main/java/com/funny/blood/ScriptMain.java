package com.funny.blood;

import com.google.inject.Injector;

public class ScriptMain extends Main {
  public static void main(String[] args) throws Exception {
    CmdParams params = new CmdParams(args);
    Main main = new ScriptMain();
    main.start(params);
  }

  @Override
  public void start(CmdParams params) throws Exception {
    ProcessType type = ProcessType.valueOf(params.getMode());
    if (type == null) {
      throw new UnsupportedOperationException("不支持的模式:" + params.getMode());
    }
    Injector injector = type.createInjector();
    injector.getInstance(ILauncher.class).registerScript();
    injector.getInstance(ILauncher.class).launch();
    injector.getInstance(AbstractShutdownHooks.class).init();
  }
}
