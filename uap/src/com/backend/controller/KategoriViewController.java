package com.backend.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.backend.Kategori;
import com.db.QueryKategori;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class KategoriViewController {

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnNext;

    @FXML
    private Label lblKategori;

    @FXML
    private Button btnPrevious;

    QueryKategori q = new QueryKategori();
    private ArrayList<Kategori> ks = q.getKategori();
    private int c = 0;
    
    // set value when start this page
    public void initialize() {
        lblKategori.setText(ks.get(0).getNama_kategori());
    }

    @FXML
    public void showKategori(int idx){
        
        Kategori k = this.ks.get(idx);
        // System.out.println(k.getNama_kategori());
        lblKategori.setText(k.getNama_kategori());

    }

    @FXML
    void addKategori(ActionEvent event) throws IOException {

        Parent newRoot = FXMLLoader.load(getClass().getResource("../../frontend/KategoriForm.fxml"));
        btnAdd.getScene().setRoot(newRoot);

    }

    @FXML
    void back(ActionEvent event) {

        if (this.c>0){

            this.c -= 1;

        }

        showKategori(this.c);

    }

    @FXML
    void deleteKategori(ActionEvent event) throws IOException {

        q.deleteKategori(this.ks.get(this.c));


        //refresh page
        Parent newRoot = FXMLLoader.load(getClass().getResource("../../frontend/KategoriView.fxml"));
        btnDelete.getScene().setRoot(newRoot);

    }

    @FXML
    void next(ActionEvent event) {

        if (this.c < this.ks.size()-1){

            this.c += 1;

        }

        showKategori(this.c);

    }

    @FXML
    void goToPrevious(ActionEvent event) throws IOException {

        Parent newRoot = FXMLLoader.load(getClass().getResource("../../frontend/HomeAdmin.fxml"));
        btnDelete.getScene().setRoot(newRoot);

    }

}
