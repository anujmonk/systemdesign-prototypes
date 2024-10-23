package com.lld.connectionpool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ConnectionpoolApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(ConnectionpoolApplication.class, args);
		Long startTime = System.currentTimeMillis();

		List<Thread> threadList = new ArrayList<>();
		BlockingQueueImpl blockingQueue = new BlockingQueueImpl();
		blockingQueue.initializeConnectionPool(10);
		for(int i=0;i<300;i++) {

//			ConnectionWithoutBlockingQueueThread connectionWithoutBlockingQueueThread = new ConnectionWithoutBlockingQueueThread("Thread " + i);
//			threadList.add(connectionWithoutBlockingQueueThread);
//			connectionWithoutBlockingQueueThread.start();
//			System.out.println("Thread creation starting");

			ConnectionWithBlockingQueueThread connectionWithBlockingQueueThread = new ConnectionWithBlockingQueueThread("Thread" + i,blockingQueue);
			threadList.add(connectionWithBlockingQueueThread);
			connectionWithBlockingQueueThread.start();
		}

		for(Thread thread: threadList) {
			thread.join();
		}

		System.out.println("All threads finished execution");
		System.out.println((System.currentTimeMillis() - startTime)/1000);
		blockingQueue.shutdown();
	}

}
