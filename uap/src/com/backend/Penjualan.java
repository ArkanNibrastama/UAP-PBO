package com.backend;

import java.util.ArrayList;

public class Penjualan implements ProductCounter{
    
    private ArrayList<Produk> listProduk;
    private int jumlahProduk, stok;
    private double total_harga;
    private String id_transaksi;

    public Penjualan(String id_transaksi, ArrayList<Produk> p){

        this.listProduk = p;
        this.id_transaksi = id_transaksi;

    }

    public String getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(String id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public void setListProduk(ArrayList<Produk> listProduk) {
        this.listProduk = listProduk;
    }

    public void setJumlahProduk(int jumlahProduk) {
        this.jumlahProduk = jumlahProduk;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public void setTotal_harga(double total_harga) {
        this.total_harga = total_harga;
    }

    public int getJumlahProduk() {
        return jumlahProduk;
    }

    public int getStok() {
        return stok;
    }

    public double getTotal_harga() {
        return total_harga;
    }

    public ArrayList<Produk> getProduk(){

        return listProduk;

    }

    @Override
    public void hitungJumlahProduk(){

        this.jumlahProduk = listProduk.size();

    }

    @Override
    public void hitungHargaProduk(){

        // harga_total
        double harga_total = 0;

        for(Produk p : this.listProduk){

            harga_total = harga_total + (p.hargaDiskon()*p.getJumlah());

        }

        this.total_harga = harga_total;

    }

}
