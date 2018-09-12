package com.funny.blood.server.hall.worker;

import com.funny.blood.woker.WeightWorker;
import com.google.inject.Inject;

public class HallWorkerDataSet {
  private final WeightWorker[] workers;

  @Inject
  public HallWorkerDataSet() {
    this.workers = new WeightWorker[Runtime.getRuntime().availableProcessors() * 2 + 1];
    for (int i = 0; i < this.workers.length; ++i) {
      this.workers[i] = new WeightWorker("hall-worker-" + i);
    }
  }

  public WeightWorker[] getWorkers() {
    return workers;
  }
}
