package com.mkyong.common;

import java.sql.*;    
public class MySQLAccess {
  private final static String DB_URL = "jdbc:oracle:thin:@//192.168.1.105:1521/MYORA";
  private final static String USER = "myuser";
  private final static String PASS = "mypwd";

  public static void main(String[] args) {
    Connection conn = null;  
    try {    
      Class.forName("oracle.jdbc.driver.OracleDriver");    
      System.out.println("Connecting to database...");    
      conn = DriverManager.getConnection(DB_URL,USER,PASS);    
    } catch (Exception e) {    
      e.printStackTrace();    
    } finally {    
      if (conn != null) {    
        try {    
          conn.close();    
        } catch (SQLException e) {    
          // ignore    
        }    
      }    
    }            
  }    
}