package com.company;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    public static Connection getMyConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/watch?autoReconnect=true&useSSL=false", "root", "1234");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
