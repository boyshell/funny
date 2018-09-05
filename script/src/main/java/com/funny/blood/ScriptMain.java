package com.funny.blood;

import com.funny.blood.shutdown.AbstractShutdownHooks;
import com.google.inject.Injector;

public class ScriptMain extends Main {
  public static void main(String[] args) throws Exception {
    CmdParams params = new CmdParams(args);
    Main main = new ScriptMain();
    main.start(params);
  }

  @Override
  public void start(CmdParams params) throws Exception {
    for (ProcessType type : ProcessType.values()) {
      if (type.key.equals(params.getMode())) {
        Injector injector = type.createInjector();
        injector.getInstance(ILauncher.class).launch();
        injector.getInstance(ILauncher.class).registerScript();
        injector.getInstance(AbstractShutdownHooks.class).init();
        return;
      }
    }
    throw new UnsupportedOperationException("不支持的模式:" + params.getMode());
  }
}