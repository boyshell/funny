package com.funny.blood;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractShutdownHooks {
  protected static final Logger logger = LoggerFactory.getLogger(AbstractShutdownHooks.class);

  public void init() {
    Runtime.getRuntime().addShutdownHook(new Thread(() -> shutdown()));
  }

  protected void shutdown(Runnable runnable, String task) {
    logger.info("start shutdown {} ...", task);
    try {
      runnable.run();
    } catch (Exception e) {
      logger.error("", e);
    }
    logger.info("shutdown {} suc", task);
  }

  protected abstract void shutdown();
}
