package com.backend.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.backend.Kategori;
import com.backend.Produk;
import com.db.QueryProduk;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ProdukViewController {

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnNext;

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

    @FXML
    private Label lblStok;

    @FXML
    private Button btnPrevious;

    /**
     * @param event
     * @throws IOException
     */

    QueryProduk q = new QueryProduk();
    private ArrayList<Produk> ps = q.getProduk();
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
         lblStok.setText(Integer.toString(p.getStok()));
    }

     @FXML
     public void showProduk(int idx){
         
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
         lblStok.setText(Integer.toString(p.getStok()));

     }

    @FXML
    void addProduk(ActionEvent event) throws IOException {

        Parent newRoot = FXMLLoader.load(getClass().getResource("../../frontend/ProdukForm.fxml"));
        btnAdd.getScene().setRoot(newRoot);

    }

    @FXML
    void back(ActionEvent event) {

        if (this.c>0){

            this.c -= 1;

        }

        showProduk(this.c);

    }

    @FXML
    void deleteProduk(ActionEvent event) throws IOException {

        q.deleteProduk(this.ps.get(this.c));


        //refresh page
        Parent newRoot = FXMLLoader.load(getClass().getResource("../../frontend/ProdukView.fxml"));
        btnDelete.getScene().setRoot(newRoot);

    }

    @FXML
    void next(ActionEvent event) {

        if (this.c < this.ps.size()-1){

            this.c += 1;

        }

        showProduk(this.c);

    }

    @FXML
    void goToPrevious(ActionEvent event) throws IOException {

        Parent newRoot = FXMLLoader.load(getClass().getResource("../../frontend/HomeAdmin.fxml"));
        btnDelete.getScene().setRoot(newRoot);

    }

}
