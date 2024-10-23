package com.lld.connectionpool;

import java.sql.Connection;

public class ConnectionWithBlockingQueueThread extends Thread {

  private String threadName;
  BlockingQueueImpl blockingQueue;

  public ConnectionWithBlockingQueueThread(String threadName,BlockingQueueImpl blockingQueue) {
    this.threadName = threadName;
    this.blockingQueue = blockingQueue;
  }

  public void run() {

    try {
//      System.out.println(this.threadName + "starting executing");
      Connection connection = this.blockingQueue.getConnection();
//        System.out.println(this.threadName + "started executing");
      DBConnection.runQuery(connection);

//      Introduced thread sleep to mimic some operation
      Thread.sleep(2000);
      this.blockingQueue.returnConnection(connection);
//      System.out.println(this.threadName + "connection closed/returned");
    } catch (Exception sqlException) {
      System.out.println(sqlException.getMessage());
    }

  }
}

