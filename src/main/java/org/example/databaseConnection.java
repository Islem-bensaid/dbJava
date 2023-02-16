package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class databaseConnection {

    public Connection getConnection(){

        Connection conn=null;
        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/offer", "root", "");

            return conn;
        } catch (Exception var3) {
            System.out.println("error:" + var3.getMessage());
            return null;
        }}}



