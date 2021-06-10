package com.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
  
// This class can be used to initialize the database connection
public class GetConnection {
    public static Connection TakeConnection()
      
    {
        Connection con=null;
        try{
        // Initialize all the information regarding
        // Database Connection
        String dbDriver = "com.mysql.cj.jdbc.Driver";
        String dbURL = "jdbc:mysql:// localhost:3306/";
        // Database name to access
        String dbName = "auction";
        String dbUsername = "root";
        String dbPassword = "mysql";
  
        Class.forName(dbDriver);
        con = DriverManager.getConnection(dbURL + dbName,dbUsername,dbPassword);
        return con;
    }
        catch(Exception e)
        {
            
        }
        return con;
    }
}