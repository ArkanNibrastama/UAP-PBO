package com.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.backend.Kategori;

public class QueryKategori {

    private final Connection CONN;

    public QueryKategori() {

        this.CONN = DBHelper.getConnection();

    }

    public ArrayList<Kategori> getKategori(){

        String query = "SELECT * FROM kategori";

        ArrayList<Kategori> k = new ArrayList<Kategori>();

        try {

            ResultSet rs = CONN.createStatement().executeQuery(query);
            while (rs.next()){

                Kategori temp = new Kategori(rs.getString("nama_kategori"));
                k.add(temp);

            }

            System.out.println("successful to get kategori");

        } catch (SQLException e) {
            
            e.printStackTrace();
            System.out.println("failed to get kategori");

        }

        return k;

    }

    public void addKategori(Kategori kategori) {

        String insert = "INSERT INTO kategori(id_kategori, nama_kategori) VALUES (NULL, '" + kategori.getNama_kategori() + "');";
        boolean add = true;

        for (Kategori k : getKategori()){

            if (kategori.getNama_kategori().equals(k.getNama_kategori())){

                add = false;

            }

        }

        try {

            if (add){

                if (CONN.createStatement().executeUpdate(insert) > 0) {

                    System.out.println("successful to add kategori");
    
                } else {
    
                    System.out.println("failed to add kategori");
    
                }

            }else{

                System.out.println("kategori telah tersedia!");

            }
            

        } catch (SQLException e) {

            e.printStackTrace();
            System.out.println("failed to add kategori");
        }

    }




    public void deleteKategori(Kategori kategori){

        String delete = "DELETE FROM kategori WHERE nama_kategori ='"+kategori.getNama_kategori()+"';";

        try {

            CONN.createStatement().executeUpdate(delete);
            System.out.println("successful to delete kategori");

        } catch (SQLException e) {

            e.printStackTrace();
            System.out.println("failed to delete kategori");
        }

    }

}
