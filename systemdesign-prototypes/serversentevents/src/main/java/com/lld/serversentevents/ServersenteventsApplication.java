package com.lld.serversentevents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync
public class ServersenteventsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServersenteventsApplication.class, args);
	}

}
