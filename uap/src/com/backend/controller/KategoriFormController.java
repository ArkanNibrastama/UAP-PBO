package com.backend.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import com.backend.Kategori;
import com.db.QueryKategori;

public class KategoriFormController {

    @FXML
    private Button btnAdd;

    @FXML
    private TextField kategoriForm;

    @FXML
    void addKategori(ActionEvent event) throws IOException {

        //push data to kategori table
        QueryKategori q = new QueryKategori();
        Kategori k =  new Kategori(kategoriForm.getText());
        q.addKategori(k);

        //automatically back to kategori view
        Parent newRoot = FXMLLoader.load(getClass().getResource("../../frontend/KategoriView.fxml"));
        btnAdd.getScene().setRoot(newRoot);

    }

}
