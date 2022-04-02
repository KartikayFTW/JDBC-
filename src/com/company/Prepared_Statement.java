package com.company;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class Prepared_Statement {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String Url = "jdbc:mysql://localhost:3306/jdbctest";
            String Username = "root";
            String Password = "root";
            Connection con = DriverManager.getConnection(Url,Username,Password);
            //create a query
            String q = "insert into table1(tname,tcity) values (?,?)";
            //get the PreparedStatement object
            PreparedStatement pstmt = con.prepareStatement(q);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter name :");
            String name = br.readLine();
            System.out.println("Enter city:");
            String city =  br.readLine();
            // Set the values to query
//            pstmt.setString(1,"john");
//            pstmt.setString(2,"Delhi");

            pstmt.setString(1,name);
           pstmt.setString(2,city);

            pstmt.executeUpdate();

            System.out.println("Inserted");

            con.close();



        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }
}
