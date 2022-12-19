package com.backend;

import java.util.ArrayList;

public class Produk {

    private String id_produk, nama_produk, jenis_produk, expired_date;
    private double harga, diskon;
    private int jumlah, stok;

    ArrayList<Kategori> kategori;

    public Produk(String id_produk, String nama_produk, ArrayList<Kategori> kategori, String jenis_produk,
    double harga, double diskon, int stok, int jumlah, String expired_date){

        this.id_produk = id_produk;
        this.nama_produk = nama_produk;
        this.kategori = kategori;
        this.jenis_produk = jenis_produk;
        this.harga = harga;
        this.diskon = diskon;
        this.jumlah = jumlah;
        this.stok = stok;
        this.expired_date = expired_date;

    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public void setDiskon(double diskon) {
        this.diskon = diskon;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getNama_produk() {
        return nama_produk;
    }

    public double getHarga() {
        return harga;
    }

    public double getDiskon() {
        return diskon;
    }

    public int getJumlah() {
        return jumlah;
    }

    public String getExpired_date() {
        return expired_date;
    }

    public void setExpired_date(String expired_date) {
        this.expired_date = expired_date;
    }

    public String getJenis_produk() {
        return jenis_produk;
    }

    public void setJenis_produk(String jenis_produk) {
        this.jenis_produk = jenis_produk;
    }

    public String getId_produk() {
        return id_produk;
    }

    public void setId_produk(String id_produk) {
        this.id_produk = id_produk;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public void setKategori(ArrayList<Kategori> kategori) {
        this.kategori = kategori;
    }

    public ArrayList<Kategori> getKategori() {
        return kategori;
    }

    public double hargaDiskon(){

        return(this.harga - this.diskon);

    }
    
}
