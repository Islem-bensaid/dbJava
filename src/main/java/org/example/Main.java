package org.example;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

//        String mysqlUrl = "jdbc:mysql://localhost:3306/candidat";
//        Connection con = DriverManager.getConnection(mysqlUrl, "root", "");
//        System.out.println("Connection established......");
//        //Creating a Statement object
//        Statement stmt = con.createStatement();
//        //Retrieving the data
//        ResultSet rs = stmt.executeQuery("Show tables");
//        System.out.println("Tables in the current database: ");
//        while(rs.next()) {
//            System.out.print(rs.getString(1));
//            System.out.println();}

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/candidat", "root", "");
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet resultSet = metaData.getTables(null, null, "%", new String[] {"TABLE"});


        List<String> tableNames = new ArrayList<>();
        List<String> colNames=new ArrayList<>();
        while (resultSet.next()) {
            String tableName=resultSet.getString("TABLE_NAME");
            tableNames.add(tableName);

        }


        for (String tableName : tableNames) {
            ResultSet rs1 = metaData.getColumns(null, null, tableName, null);

            while (rs1.next()) {
                String name = rs1.getString("COLUMN_NAME");
                String type = rs1.getString("TYPE_NAME");
                int size = rs1.getInt("COLUMN_SIZE");

                System.out.println("Column name: [" + name + "]; type: [" + type + "]; size: [" + size + "]");
            }
        }
        System.out.println(tableNames);

        resultSet.close();
        connection.close();



    }
}