package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Dreiwer {
    public void dreiwer(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Properties soedinenie(){
        Properties prop = new Properties();
        prop.put("user", "root");
        prop.put("password", "1234");
        prop.put("autoReconnect", "true");
        prop.put("characterEncoding","UTF-8");
        prop.put("useUnicode","true");
        return prop;

    }

    public static void price(){
        String url = "jdbc:mysql://localhost:3306/strachowanije";
        Dreiwer dreiwer = new Dreiwer();
        Properties a = dreiwer.soedinenie();

        try {
            Connection connection = DriverManager.getConnection(url,a);
            Statement statement = connection.createStatement();
            String str = "SELECT sum(price) FROM strachowka";
            ResultSet resultSet = statement.executeQuery(str);
            int b = 0;
            while (resultSet.next()){
                b = resultSet.getInt(1);
            }

            System.out.println(b);

        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void sort(){
        String url = "jdbc:mysql://localhost:3306/strachowanije";
        Dreiwer dreiwer = new Dreiwer();
        Properties a = dreiwer.soedinenie();

        try {
            Connection connection = DriverManager.getConnection(url,a);
            Statement statement = connection.createStatement();
            String str = "SELECT * FROM strachowka ORDER BY tip";
            ResultSet resultSet = statement.executeQuery(str);
            List<StrachowkaSQL> strachowkaSQLS = new ArrayList<>();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String strachowka = resultSet.getString(3);
                int price = resultSet.getInt(4);
                int tip = resultSet.getInt(5);
                strachowkaSQLS.add(new StrachowkaSQL(id,name,strachowka,price,tip));
            }

            System.out.println(strachowkaSQLS);

        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
