package com.db;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String DB = "uap_pbo";
    private static final String MYCONN = "jdbc:mysql://localhost/" + DB;

    public static Connection getConnection() {
        
        Connection conn = null;

        try {

            conn = DriverManager.getConnection(MYCONN, USERNAME, PASSWORD);
            System.out.println("connection running successfully");

        } catch (SQLException e) {

            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("connection failed");

        }

        return conn;

    }
    
}
