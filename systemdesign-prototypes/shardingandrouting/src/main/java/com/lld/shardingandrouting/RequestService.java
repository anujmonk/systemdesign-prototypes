package com.lld.shardingandrouting;

import com.lld.connectionpool.DbConnection;
import com.lld.connectionpool.DbConnection2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class RequestService {

  DbConnection dbConnection;

  DbConnection2 dbConnection2;

  public RequestService() {
    dbConnection = new DbConnection();
    dbConnection2 = new DbConnection2();
  }

  public void handleUserRequest(int userId)  {

    try {
      if (userId % 2 == 0) {
        dbConnection.runQuery(dbConnection.createConnection());
      } else {
        dbConnection2.runQuery(dbConnection2.createConnection());
      }
    }
    catch (SQLException e) {
      System.out.println(e.getMessage());
    }

  }

}
