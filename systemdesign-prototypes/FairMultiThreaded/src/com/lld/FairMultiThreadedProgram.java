package com.lld;


import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class FairMultiThreadedProgram {

  public static void main(String[] args) {

    int MAX_VAL = 1000000000;

//    No multi threading approach
    // WithoutMultiThreading withoutMultiThreading = new WithoutMultiThreading(MAX_VAL);

//    With Multi threading but unequal weight or work distribution among threads (equal batch of numbers between the range)
//    WithMultiThreading withMultiThreading = new WithMultiThreading(MAX_VAL);

//    With MultiThreading but equal weight or work distribution among threads (Thread will continuously pick a number and update the count)
    TrueMultithreading trueMultithreading = new TrueMultithreading(MAX_VAL);
  }
}
