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
    void addProduk(ActionEvent event) throws IOException {

        QueryKategori qk = new QueryKategori();
        ArrayList<Kategori> ktable = qk.getKategori();
        boolean kategoriNotFound = false;

        ArrayList<Kategori> ks = new ArrayList<>();
        String kategori = kategoriForm.getText();
        for (String s : kategori.split(", ")){

            System.out.println(s);
            Kategori k = new Kategori(s);

            int counter = 0;
            for (Kategori kt : ktable){

                if (kt.getNama_kategori().equals(k.getNama_kategori())){

                    counter += 1;

                }

            }

            if (counter == 0){

                kategoriNotFound = true;
                break;

            }

            ks.add(k);

        }

        if (kategoriNotFound == false){

            //push data to produk table
            QueryProduk q = new QueryProduk();
            Produk p =  new Produk(null, namaProdukForm.getText(), ks, jenisProdukForm.getText(), Double.parseDouble(hargaForm.getText()),
            Double.parseDouble(diskonForm.getText()), Integer.parseInt(stokForm.getText()), 0, null);
            q.addProduk(p);

            Parent newRoot = FXMLLoader.load(getClass().getResource("../../frontend/ProdukView.fxml"));
            btnAdd.getScene().setRoot(newRoot);

        }else{

            System.out.println("kategori tidak dapat ditemukan!");

            //refresh
            Parent newRoot = FXMLLoader.load(getClass().getResource("../../frontend/ProdukForm.fxml"));
            btnAdd.getScene().setRoot(newRoot);

        }

    }

}
