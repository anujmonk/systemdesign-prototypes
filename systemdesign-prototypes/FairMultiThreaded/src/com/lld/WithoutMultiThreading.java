package com.lld;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class WithoutMultiThreading {

  public WithoutMultiThreading(int MAX_VAL) {
    CheckPrimeClass checkPrimeClass = new CheckPrimeClass();

    LocalTime startTime = LocalTime.now();

    int withoutMultiThreading = checkPrimeClass.countPrimes(MAX_VAL);

    System.out.println("Checking till " + MAX_VAL + " found " + withoutMultiThreading +
            " prime numbers, took " + startTime.until(LocalTime.now(), ChronoUnit.SECONDS));

  }



}
