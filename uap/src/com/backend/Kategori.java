package com.backend;

public class Kategori {
    
    private String nama_kategori;
    private Produk produk;

    public Kategori(String k){

        this.nama_kategori = k;

    }

    public void setNama_kategori(String nama_kategori) {

        this.nama_kategori = nama_kategori;

    }

    public void setProduk(Produk produk) {

        this.produk = produk;
        
    }


    public String getNama_kategori() {

        return nama_kategori;

    }

    public Produk getProduk(){

        return produk;

    }

}
