package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertSQL {
    public static void main(String[] args) {
        try {
            //Register Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Create Connection
            String Url = "jdbc:mysql://localhost:3306/jdbctest";
            String Username = "root";
            String Password = "root";
            Connection cn = DriverManager.getConnection(Url,Username,Password);
            if(cn.isClosed()) {
                System.out.println("Connection is closed");

            }
            else {
                System.out.println("Connection open");
            }
            //Create a statement
            Statement st = cn.createStatement();
            //create a query
            String q = "CREATE table table1(tId int(20) primary key auto_increment,tName VARCHAR(20) not null , tCity VARCHAR(400))";
            //execute a query
            st.executeUpdate(q);
            System.out.println("Table created in database..");



            cn.close();
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }
}
