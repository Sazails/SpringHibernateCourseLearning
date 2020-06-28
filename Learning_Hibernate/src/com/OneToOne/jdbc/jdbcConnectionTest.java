package com.OneToOne.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class jdbcConnectionTest {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_01_one_to_one_uni?useSSL=false&serverTimezone=UTC";
        String user = "hbuser";
        String password = "hbuser";

        try{
            System.out.println("CONNECTING");
            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("CONNECTED");
            connection.close();
            System.out.println("DISCONNECTING");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
