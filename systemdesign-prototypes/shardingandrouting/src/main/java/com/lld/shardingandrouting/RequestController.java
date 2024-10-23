package com.lld.shardingandrouting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

  @Autowired
  RequestService requestService;

  @GetMapping("/users/{userId}")
  public void handleRequestFromUser(@PathVariable("userId") int userId) {

    requestService.handleUserRequest(userId);

  }
}
