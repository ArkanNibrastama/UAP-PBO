package com.backend.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.backend.Kategori;
import com.backend.Penjualan;
import com.backend.Produk;
import com.db.QueryPenjualan;
import com.db.QueryProduk;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class KatalogController {

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnCheckOut;

    @FXML
    private Button btnNext;

    @FXML
    private TextField formJumlah;

    @FXML
    private Label lblDiskon;

    @FXML
    private Label lblHarga;

    @FXML
    private Label lblJenisProduk;

    @FXML
    private Label lblKategori;

    @FXML
    private Label lblNamaProduk;

    QueryProduk qpro = new QueryProduk();
    QueryPenjualan q = new QueryPenjualan();
    private ArrayList<Produk> bucket = new ArrayList<>();
    private ArrayList<Produk> ps = qpro.getProduk();
    private int c = 0;

    public void initialize() {
        Produk p = this.ps.get(0);
         lblNamaProduk.setText(p.getNama_produk());
         ArrayList<Kategori> ks = p.getKategori();
         String kategori = "";
         int counter = 0;
         for(Kategori k : ks){

            if (counter == 0){

                kategori = kategori + k.getNama_kategori();

            }else{

                kategori = kategori + ", " + k.getNama_kategori();

            }

            counter += 1;

         }
         lblKategori.setText(kategori);
         lblJenisProduk.setText(p.getJenis_produk());
         lblHarga.setText(Double.toString(p.getHarga()));
         lblDiskon.setText(Double.toString(p.getDiskon()));

    }

    public void showKatalog(int idx){

        Produk p = this.ps.get(idx);
        lblNamaProduk.setText(p.getNama_produk());
        ArrayList<Kategori> ks = p.getKategori();
        String kategori = "";
        int counter = 0;
        for(Kategori k : ks){

            if (counter == 0){

                kategori = kategori + k.getNama_kategori();

            }else{

                kategori = kategori + ", " + k.getNama_kategori();

            }

            counter += 1;

        }
        lblKategori.setText(kategori);
        lblJenisProduk.setText(p.getJenis_produk());
        lblHarga.setText(Double.toString(p.getHarga()));
        lblDiskon.setText(Double.toString(p.getDiskon()));
        formJumlah.clear();

    }

    @FXML
    void addProduk(ActionEvent event) {

        Produk p = this.ps.get(this.c);
        p.setJumlah(Integer.parseInt(formJumlah.getText()));
        this.bucket.add(p);
        formJumlah.clear();

    }

    @FXML
    void back(ActionEvent event) {
        if (this.c>0){

            this.c -= 1;

        }

        showKatalog(this.c);
    }

    @FXML
    void checkout(ActionEvent event) throws IOException {

        Penjualan penjualan = new Penjualan(null, this.bucket);
        q.addPenjualan(penjualan);

        Parent newRoot = FXMLLoader.load(getClass().getResource("../../frontend/HomeUser.fxml"));
        btnCheckOut.getScene().setRoot(newRoot);

    }

    @FXML
    void next(ActionEvent event) {

        if (this.c < this.ps.size()-1){

            this.c += 1;

        }

        showKatalog(this.c);

    }

}
