package com.company;

import javax.sql.RowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;

public class Row_Set {
    public static void main(String[] args) {
        try {
            //Registering the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Creating row set
            RowSet rs = RowSetProvider.newFactory().createJdbcRowSet();
            //setting the url
            String url = "jdbc:mysql://localhost:3306/jdbctest";
            String Username = "root";
            String Password = "root";
            rs.setUrl(url);
            rs.setUsername(Username);
            rs.setPassword(Password);
            //setting the query
            rs.setCommand("Select * from table1");
            rs.execute();
            System.out.println("Contents of the table");
            while (rs.next()) {
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            }
            System.out.println("-----");




        }
        catch (Exception e) {

        }
    }
}
