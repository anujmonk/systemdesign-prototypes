package com.lld;

import java.util.concurrent.atomic.AtomicInteger;

public class CheckPrimeClass {

  public int countPrimes(int value) {
    int count = 0;

    for (int i = 2; i <= value; i++) {
      if (isPrime(i)) {  // Call isPrime to check if `i` is a prime number
        count++;       // Increment count if `i` is prime
      }
    }

    return count;  // Return the total count of prime numbers up to `value`
  }

  public AtomicInteger countPrimesForMultiThreading(int value) {
    AtomicInteger count = new AtomicInteger(0);

    for (int i = 2; i <= value; i++) {
      if (isPrime(i)) {  // Call isPrime to check if `i` is a prime number
        count.incrementAndGet();       // Increment count if `i` is prime
      }
    }

    return count;  // Return the total count of prime numbers up to `value`
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
