package com.backend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Makanan extends Produk{
    
    private int daya_tahan;
    private String expired_date;

    public Makanan(String id_produk, String nama_produk, ArrayList<Kategori> kategori, String jenis_produk,
    double harga, double diskon, int stok, int jumlah, String expired_date, int daya_tahan){

        super(id_produk, nama_produk, kategori, jenis_produk, harga, diskon, stok, jumlah, expired_date);
        this.daya_tahan = daya_tahan;
        this.expired_date = expired_date;

    }

    public void setDaya_tahan(int daya_tahan) {
        this.daya_tahan = daya_tahan;
    }

    public int getDaya_tahan() {
        return daya_tahan;
    }


    public boolean isSpoiled() throws ParseException{

        boolean spoiled = false;

        Date date_today = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date_expired = dateFormat.parse(this.expired_date);

        if (date_today.compareTo(date_expired) > 0){

            spoiled = true;

        }


        return spoiled;

    }


}
