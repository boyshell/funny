package com.funny.blood.net;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AbstractDispatcherTest {
  @Test
  public void test() throws InterruptedException {
    ExecutorService service = Executors.newFixedThreadPool(1);
    for (int i = 0; i < 10; ++i) {
      service.execute(
          () -> {
            A a = new A();
            System.out.println(a.local.get());
            a.local.set(a.local.get() == null ? 0 : a.local.get() + 1);
          });
    }
    Thread.sleep(1000);
  }

  static class A {
    ThreadLocal<Integer> local = new ThreadLocal<>();
  }
}
