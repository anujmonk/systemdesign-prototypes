package com.lld.serversentevents.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class SseController {

  private static final int MAX_EXECUTIONS = 10;

  @GetMapping("/stream-sse")
  public SseEmitter streamTime() {
    SseEmitter sseEmitter = new SseEmitter(0L);

    AtomicInteger counter = new AtomicInteger();
    ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    executorService.scheduleAtFixedRate(() -> {
      try {
        if (counter.get() < MAX_EXECUTIONS) {
          sseEmitter.send("Current Time : " + LocalTime.now() + " ");
          counter.getAndIncrement();
        } else {
          sseEmitter.send("Emission Completed");
          sseEmitter.complete();
        }
      } catch (Exception exception) {
        sseEmitter.completeWithError(exception);
      }
    }, 5, 2, TimeUnit.SECONDS);

    sseEmitter.onCompletion(executorService::shutdown);

    return sseEmitter;
  }

}
