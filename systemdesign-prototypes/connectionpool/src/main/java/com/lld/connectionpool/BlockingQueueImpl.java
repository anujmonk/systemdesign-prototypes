package com.lld.connectionpool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueImpl {

  BlockingQueue<Connection> dbConnectionBlockingQueue;
  DBConnection dbConnection;

  public void initializeConnectionPool(int poolSize) {
    try {
      dbConnectionBlockingQueue = new LinkedBlockingQueue<>(poolSize);
      for (int i = 0; i < poolSize; i++) {
        Connection connection = dbConnection.createConnection();
        dbConnectionBlockingQueue.offer(connection);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeException("Error initializing the connection pool.", e);
    }
  }

  public Connection getConnection() throws InterruptedException {
    return dbConnectionBlockingQueue.take(); // Waits if necessary for a connection to become available
  }

  public void returnConnection(Connection connection) {
    if (connection != null) {
      dbConnectionBlockingQueue.offer(connection); // Returns the connection to the pool
    }
  }

  public void shutdown() {
    for (Connection connection : dbConnectionBlockingQueue) {
      try {
        if (connection != null && !connection.isClosed()) {
          connection.close();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }



}
