package com.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.backend.Penjualan;
import com.backend.Produk;

public class QueryPenjualan {

    private final Connection CONN;

    public QueryPenjualan() {

        this.CONN = DBHelper.getConnection();

    }

    public ArrayList<Penjualan> getPenjualan() {

        String query1 = "SELECT * FROM penjualan GROUP BY id_transaksi;";
        ArrayList<Penjualan> list_penjualan = new ArrayList<Penjualan>();

        try {

            ResultSet rs = CONN.createStatement().executeQuery(query1);
            while (rs.next()) {

                String current_id = rs.getString("id_transaksi");
                String query2 = "SELECT * FROM penjualan WHERE id_transaksi = '" + current_id + "';";
                ResultSet rs2 = CONN.createStatement().executeQuery(query2);
                ArrayList<Produk> p = new ArrayList<Produk>();
                QueryProduk q = new QueryProduk();

                // satuin kategori
                while (rs2.next()) {

                    // Produk temp = new Produk(rs2.getString("kategori"));
                    // p.add(temp);

                    for (Produk produk : q.getProduk()) {

                        if (produk.getNama_produk().equals(rs2.getString("produk"))) {

                            produk.setJumlah(rs2.getInt("jumlah"));
                            p.add(produk);

                        }

                    }

                }

                Penjualan temp = new Penjualan(current_id, p);
                list_penjualan.add(temp);

            }

            System.out.println("successful to get penjualan");

        } catch (SQLException e) {

            e.printStackTrace();
            System.out.println("failed to get penjualan");

        }

        return list_penjualan;

    }

    public int getLastIndex(){

        String query = "SELECT MAX(id_transaksi) AS idx FROM penjualan;";
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

    public void addPenjualan(Penjualan penjualan) {

        int idx = getLastIndex() + 1;
        penjualan.setId_transaksi(Integer.toString(idx));

        Date d = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        for (Produk p : penjualan.getProduk()){

            String insert = "INSERT INTO penjualan(id_transaksi, tanggal_transaksi, produk, jumlah)"+
            "VALUES ('"+idx+"', '" + dateFormat.format(d) + "', '" +p.getNama_produk()+
            "', '"+ p.getJumlah() +"');";

            try {

                if (CONN.createStatement().executeUpdate(insert) > 0) {

                        System.out.println("successful to add penjualan");
        
                } else {
        
                        System.out.println("failed to add penjualan");
        
                }
                    

            } catch (SQLException e) {

                e.printStackTrace();
                System.out.println("failed to add penjualan");
            }

        }

    }

    public void deletePenjualan(Penjualan penjualan){

        String delete = "DELETE FROM penjualan WHERE id_transaksi ='"+penjualan.getId_transaksi()+"';";
        System.out.println(penjualan.getId_transaksi());

        try {

            CONN.createStatement().executeUpdate(delete);
            System.out.println("successful to delete penjualan");

        } catch (SQLException e) {

            e.printStackTrace();
            System.out.println("failed to delete penjualan");
        }

    }

}
