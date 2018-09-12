package com.funny.blood.woker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shell.time.TimeUtil;
import shell.util.concurrent.Worker;

import java.util.concurrent.atomic.AtomicInteger;

public class WeightWorker<T> extends Worker<UserEvent<T>> {
  private static final Logger logger = LoggerFactory.getLogger(WeightWorker.class);
  private final AtomicInteger weight = new AtomicInteger();

  public WeightWorker(String name) {
    super(name);
  }

  @Override
  protected UserEvent createEvent() {
    return new UserEvent();
  }

  public void execute(T user, UserTask<T> task) {
    long next = ringBuffer.next();
    try {
      UserEvent<T> event = ringBuffer.get(next);
      event.setUser(user);
      event.setUserTask(task);
    } finally {
      ringBuffer.publish(next);
    }
  }

  @Override
  public void onEvent(UserEvent event, long sequence, boolean endOfBatch) throws Exception {
    try {
      if (event.getUserTask() != null && event.getUser() != null) {
        long delta = TimeUtil.millis();
        event.getUserTask().exec(event.getUser());
        delta = TimeUtil.millis() - delta;
        if (delta > 10) {
          logger.warn("{} execute too slow! {}ms", event.getUserTask().getName(), delta);
        }
        return;
      }

      super.onEvent(event, sequence, endOfBatch);
    } finally {
      event.setUserTask(null);
      event.setUser(null);
      event.setTask(null);
    }
  }

  public int getWeight() {
    return weight.get();
  }

  public void borrow() {
    weight.incrementAndGet();
  }

  public void giveBack() {
    weight.decrementAndGet();
  }
}
