package com.lld;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class CheckPrimeClassWithThreading implements Runnable{

  int start;
  int end;
  String threadName;

  public CheckPrimeClassWithThreading(int start,int end,String threadName) {
    this.start = start;
    this.end = end;
    this.threadName = threadName;
  }

  public void run() {

    LocalTime startTime = LocalTime.now();
    int count = 0;

    for(int i=start;i<end;i++) {
      if (isPrime(i)) {  // Call isPrime to check if `i` is a prime number
        count++;       // Increment count if `i` is prime
      }
    }


    System.out.println(this.threadName + " for range " + this.start + " - " + this.end + " found " + count +
            " prime numbers, took " + startTime.until(LocalTime.now(), ChronoUnit.SECONDS));

  }

  private boolean isPrime(int number) {
    if (number <= 1) {
      return false; // Not prime
    }
    if (number == 2) {
      return true; // 2 is prime
    }
    if ((number & 1) == 0) {
      return false; // Even numbers greater than 2 are not prime
    }

    for (int i = 3; i <= Math.sqrt(number); i += 2) {
      if (number % i == 0) {
        return false; // Not prime
      }
    }
    return true; // Prime
  }
}
