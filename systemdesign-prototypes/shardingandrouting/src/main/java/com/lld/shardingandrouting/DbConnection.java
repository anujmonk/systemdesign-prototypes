package com.lld.connectionpool;

import org.springframework.context.annotation.Bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConnection {

  private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/localdb";
  private static final String USER = "anujsharma";
  private static final String PASSWORD = "anujsharma";

  public static Connection createConnection() throws SQLException {

    Connection conn = null;
    try {
      conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
//      System.out.println("Connection Created");
    }
    catch (Exception e) {
      System.out.println("Error connecting to the database: " + e.getMessage());
    }
    return conn;
  }

  public static void runQuery(Connection connection) throws SQLException {
    var statement = connection.createStatement();
    statement.execute("SELECT 1");
    System.out.println("Request sent to Connection 1");
  }
}