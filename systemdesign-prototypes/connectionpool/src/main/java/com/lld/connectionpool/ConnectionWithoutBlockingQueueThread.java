package com.lld.connectionpool;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionWithoutBlockingQueueThread extends Thread {

  private String threadName;

  public ConnectionWithoutBlockingQueueThread(String threadName) {
    this.threadName = threadName;
  }

  public void run(){

    try {
        Connection connection = DBConnection.createConnection();
//        System.out.println(this.threadName + "started executing");
        DBConnection.runQuery(connection);

        Thread.sleep(2000);
        connection.close();
//      System.out.println(this.threadName + "connection closed");
      }
    catch (Exception sqlException) {
        System.out.println(sqlException.getMessage());
      }

  }

}
