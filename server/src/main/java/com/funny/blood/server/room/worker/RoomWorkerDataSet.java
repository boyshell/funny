package com.funny.blood.server.room.worker;

import com.funny.blood.woker.WeightWorker;
import com.google.inject.Inject;

public class RoomWorkerDataSet {
  private final WeightWorker[] workers;

  @Inject
  public RoomWorkerDataSet() {
    workers = new WeightWorker[Runtime.getRuntime().availableProcessors() * 2 + 1];
    for (int i = 0; i < workers.length; ++i) {
      workers[i] = new WeightWorker("room-worker-" + i);
    }
  }

  public WeightWorker[] getWorkers() {
    return workers;
  }
}
