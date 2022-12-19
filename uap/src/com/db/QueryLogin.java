package com.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryLogin {

    private final Connection CONN;

    public QueryLogin() {

        this.CONN = DBHelper.getConnection();

    }

    private ArrayList<String> usernames = new ArrayList<>();
    private ArrayList<String> passwords = new ArrayList<>();

    public void getData(){

        String query = "SELECT * FROM login";

        try {

            ResultSet rs = CONN.createStatement().executeQuery(query);
            while (rs.next()){

                this.usernames.add(rs.getString("username"));
                this.passwords.add(rs.getString("password"));

            }

            System.out.println("successful to get data");

        } catch (SQLException e) {
            
            e.printStackTrace();
            System.out.println("failed to get kategori");

        }

    }

    public ArrayList<ArrayList<String>> getLogin(){

        getData();
        ArrayList<ArrayList<String>> temp = new ArrayList<>();
        temp.add(this.usernames);
        temp.add(this.passwords);
        return temp;

    }


    
}
