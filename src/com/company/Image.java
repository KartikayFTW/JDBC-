package com.company;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Image {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String Url = "jdbc:mysql://localhost:3306/jdbctest";
            String Username = "root";
            String Password = "root";
            Connection con = DriverManager.getConnection(Url,Username,Password);
            String q = "INSERT INTO images(pic) values(?)";
            PreparedStatement pstmt = con.prepareStatement(q);
            FileInputStream fis = new FileInputStream("C:/abc.jpg");
            pstmt.setBinaryStream(1,fis,fis.available());
            pstmt.executeUpdate();
            System.out.println("Inserted");

        }
        catch (Exception e) {
            e.getStackTrace();
        }
     }
}
