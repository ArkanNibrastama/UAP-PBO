package com.backend.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.backend.Kategori;
import com.backend.Produk;
import com.db.QueryKategori;
import com.db.QueryProduk;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ProdukFormController {

    @FXML
    private Button btnAdd;

    @FXML
    private TextField diskonForm;

    @FXML
    private TextField hargaForm;

    @FXML
    private TextField jenisProdukForm;

    @FXML
    private TextField kategoriForm;

    @FXML
    private TextField namaProdukForm;

    @FXML
    private TextField stokForm;

    @FXML
    private Button btnPrevious;

    @FXML
    private Label lblWarning;

    public void initialize() {

        lblWarning.setText("");

    }

    @FXML
    void addProduk(ActionEvent event) throws IOException {

        QueryKategori qk = new QueryKategori();
        ArrayList<Kategori> ktable = qk.getKategori();
        boolean kategoriNotFound = false;

        ArrayList<Kategori> ks = new ArrayList<>();
        String kategori = kategoriForm.getText();
        for (String s : kategori.split(", ")) {

            System.out.println(s);
            Kategori k = new Kategori(s);

            int counter = 0;
            for (Kategori kt : ktable) {

                if (kt.getNama_kategori().equals(k.getNama_kategori())) {

                    counter += 1;

                }

            }

            if (counter == 0) {

                kategoriNotFound = true;
                break;

            }

            ks.add(k);

        }

        QueryProduk qp = new QueryProduk();
        ArrayList<Produk> ptable = qp.getProduk();
        boolean produkExist = false;

        for (Produk p : ptable){

            if (namaProdukForm.getText().equals(p.getNama_produk())){

                produkExist = true;
                break;

            }

        }


        if (produkExist == false){


            if (kategoriNotFound == false) {

                // push data to produk table
                Produk p = new Produk(null, namaProdukForm.getText(), ks, jenisProdukForm.getText(),
                        Double.parseDouble(hargaForm.getText()),
                        Double.parseDouble(diskonForm.getText()), Integer.parseInt(stokForm.getText()), 0, null);
                qp.addProduk(p);
    
                Parent newRoot = FXMLLoader.load(getClass().getResource("../../frontend/ProdukView.fxml"));
                btnAdd.getScene().setRoot(newRoot);
    
            } else {
    
                System.out.println("kategori tidak dapat ditemukan!");
                lblWarning.setText("kategori tidak dapat ditemukan!");
    
                // refresh
                namaProdukForm.clear();
                jenisProdukForm.clear();
                kategoriForm.clear();
                hargaForm.clear();
                diskonForm.clear();
                stokForm.clear();
    
            }

        }else{

            System.out.println("produk sudah ada di database!");
            lblWarning.setText("produk sudah ada di database!");

            // refresh
            namaProdukForm.clear();
            jenisProdukForm.clear();
            kategoriForm.clear();
            hargaForm.clear();
            diskonForm.clear();
            stokForm.clear();

        }

    }

    @FXML
    void goToPrevious(ActionEvent event) throws IOException {

        Parent newRoot = FXMLLoader.load(getClass().getResource("../../frontend/ProdukView.fxml"));
        btnAdd.getScene().setRoot(newRoot);

    }

}
