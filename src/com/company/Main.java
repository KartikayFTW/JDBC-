package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            String Url = "jdbc:mysql://localhost:3306/jdbctest";
            String Username = "root";
            String Password = "root";
            Connection cn =DriverManager.getConnection(Url,Username,Password);
            if(cn.isClosed()) {
                System.out.println("Connection is closed");

            }
            else {
                System.out.println("Connection open");
            }
            String q = "SELECT * FROM table1";
            Statement st = cn.createStatement();
           ResultSet rs = st.executeQuery(q);
           while (rs.next()) {
               System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
           }
        }

        catch (Exception e) {
            e.getStackTrace();
        }

    }
}
