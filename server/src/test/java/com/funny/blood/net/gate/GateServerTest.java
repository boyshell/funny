package com.funny.blood.net.gate;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.BiFunction;

import static org.junit.Assert.*;

public class GateServerTest {
  @Test
  public void test() throws InterruptedException {
    String key = "1";
    BiMap<String, Integer> channelID2userID = Maps.synchronizedBiMap(HashBiMap.create());
    channelID2userID.put(key, 0);
    ScheduledExecutorService service =
        Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());
    for (int i = 0; i < 1000000; ++i) {
      service.execute(() -> channelID2userID.computeIfPresent(key, (k, v) -> v + 1));
    }
    Thread.sleep(10000);
    System.out.println(channelID2userID.get(key));
  }
}
