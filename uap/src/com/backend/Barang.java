package com.backend;

import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Barang extends Produk{

    private String barcode, today, expired;
    private ArrayList<Kategori> kategori;

    public Barang(String id_produk, String nama_produk, ArrayList<Kategori> kategori, String jenis_produk,
    double harga, double diskon, int stok, int jumlah, String expired_date, String barcode){

        super(id_produk, nama_produk, kategori, jenis_produk, harga, diskon, stok, jumlah, expired_date);
        this.barcode = barcode;
        this.kategori = kategori;
        this.expired = expired_date;

    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public void setToday(String today) {
        this.today = today;
    }

    public void setKategori(ArrayList<Kategori> kategori) {
        this.kategori = kategori;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getToday() {
        return today;
    }

    public ArrayList<Kategori> getKategori() {
        return kategori;
    }

    public boolean isExpired() throws ParseException{

        boolean exp = false;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date_today = dateFormat.parse(this.today);
        Date date_expired = dateFormat.parse(this.expired);

        if (date_today.compareTo(date_expired) > 0){

            exp = true;

        }


        return exp;

    }

    public void addKategori(Kategori kategori) {

        this.kategori.add(kategori);

    }
    
}
