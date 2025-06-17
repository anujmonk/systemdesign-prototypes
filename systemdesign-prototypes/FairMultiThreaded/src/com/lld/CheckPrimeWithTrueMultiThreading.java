package com.lld;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CheckPrimeWithTrueMultiThreading implements Runnable{

  AtomicInteger currentNumber;
  AtomicInteger numberOfPrime;
  int MAX_VALUE;

  public CheckPrimeWithTrueMultiThreading(AtomicInteger currentNumber, AtomicInteger numberOfPrime, int MAX_VALUE) {
    this.currentNumber = currentNumber;
    this.numberOfPrime = numberOfPrime;
    this.MAX_VALUE=MAX_VALUE;
  }

  public void run() {
    int number;
    while((number = this.currentNumber.getAndIncrement()) <= MAX_VALUE) {
      if (isPrime(number)) {  // Call isPrime to check if `i` is a prime number
        numberOfPrime.incrementAndGet();       // Increment count if `i` is prime
      }
    }


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
