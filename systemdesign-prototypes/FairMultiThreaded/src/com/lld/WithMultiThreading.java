package com.lld;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class WithMultiThreading {
    /*
    * All threads doing unequal amount of time, batch the range and give each thread one batch
    */
  int MAX_Threads = 10;

  public WithMultiThreading(int MAX_VAL) {

    int rangePerThread = (MAX_VAL - 1 + 1) / MAX_Threads;

    Thread[] threads = new Thread[MAX_Threads];
    for (int i = 0; i < MAX_Threads; i++) {
      int start = 1 + i * rangePerThread;
      int end = (i == MAX_VAL - 1) ? MAX_VAL : start + rangePerThread - 1;
      threads[i] = new Thread(new CheckPrimeClassWithThreading(start, end, "Thread " + i));
      threads[i].start();
    }

    // Wait for all threads to finish
    for (Thread thread : threads) {
      try {
        thread.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }


  }

}
