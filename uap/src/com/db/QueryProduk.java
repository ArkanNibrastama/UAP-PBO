package com.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.backend.Kategori;
import com.backend.Produk;

public class QueryProduk {

    private final Connection CONN;

    public QueryProduk() {

        this.CONN = DBHelper.getConnection();

    }

    public ArrayList<Produk> getProduk(){

        String query1 = "SELECT * FROM produk GROUP BY id_produk;";
        ArrayList<Produk> p = new ArrayList<Produk>();

        try {

            ResultSet rs = CONN.createStatement().executeQuery(query1);
            while (rs.next()){

                String current_id = rs.getString("id_produk");
                String query2 = "SELECT * FROM produk WHERE id_produk = '"+current_id+"';";
                ResultSet rs2 = CONN.createStatement().executeQuery(query2);
                ArrayList<Kategori> k = new ArrayList<Kategori>();

                //satuin kategori
                while(rs2.next()){

                    Kategori temp = new Kategori(rs2.getString("kategori"));
                    k.add(temp);

                }

                Produk temp = new Produk(rs.getString("id_produk"),
                rs.getString("nama_produk"), k, rs.getString("jenis_produk"),
                rs.getDouble("harga"), rs.getDouble("diskon"), rs.getInt("stok"),
                0, rs.getString("expired_or_spoiled_date"));
                p.add(temp);

            }

            System.out.println("successful to get produk");

        } catch (SQLException e) {

                e.printStackTrace();
                System.out.println("failed to get produk");

        }

        return p;

    }

    public int getLastIndex(){

        String query = "SELECT MAX(id_produk) AS idx FROM produk;";
        int idx = 0;
        
        try {

            ResultSet rs = CONN.createStatement().executeQuery(query);
            
            while(rs.next()){

                idx = rs.getInt("idx");

            }

            System.out.println("successful to get last index");

        } catch (SQLException e) {
            
            e.printStackTrace();
            System.out.println("failed to get last index");

        }

        return idx;

    }

    public void addProduk(Produk produk) {

        int idx = getLastIndex() + 1;

        for (Kategori k : produk.getKategori()){

            String insert = "INSERT INTO produk(id_produk, nama_produk, kategori, jenis_produk, harga, diskon, stok, expired_or_spoiled_date)"+
            "VALUES ('"+idx+"', '" + produk.getNama_produk() + "', '" +k.getNama_kategori()+
            "', '"+ produk.getJenis_produk() +"', '"+produk.getHarga()+"', '"+produk.getDiskon()+
            "', '"+produk.getStok()+"', '"+produk.getExpired_date()+
            "');";

            try {

                if (CONN.createStatement().executeUpdate(insert) > 0) {

                        System.out.println("successful to add produk");
        
                } else {
        
                        System.out.println("failed to add produk");
        
                }
                    

            } catch (SQLException e) {

                e.printStackTrace();
                System.out.println("failed to add produk");
            }

        }

    }


    public void deleteProduk(Produk produk){

        String delete = "DELETE FROM produk WHERE nama_produk ='"+produk.getNama_produk()+"';";

        try {

            CONN.createStatement().executeUpdate(delete);
            System.out.println("successful to delete produk");

        } catch (SQLException e) {

            e.printStackTrace();
            System.out.println("failed to delete produk");
        }

    }



}
