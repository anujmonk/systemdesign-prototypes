package com.lld;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TrueMultithreading {

  /*
  * All threads doing equal amount of time
  * */

  int Max_Threads = 10;
  AtomicInteger currentNum = new AtomicInteger(1);
  AtomicInteger countOfPrime = new AtomicInteger(0);

  public TrueMultithreading(int MAX_VAL) {

    Thread[] threads = new Thread[Max_Threads];

    LocalTime startTime = LocalTime.now();

    for(int i=0;i<threads.length;i++) {
      threads[i] = new Thread(new CheckPrimeWithTrueMultiThreading(currentNum,countOfPrime,MAX_VAL));;
      threads[i].start();
    }

    for (Thread thread : threads) {
      try {
        thread.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    System.out.println(" found " + countOfPrime +
            " prime numbers, took " + startTime.until(LocalTime.now(), ChronoUnit.SECONDS));

  }
}
