package com.backend.controller;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import com.backend.Kategori;
import com.db.QueryKategori;

public class KategoriFormController {

    @FXML
    private Button btnAdd;

    @FXML
    private TextField kategoriForm;

    @FXML
    private Button btnPrevious;

    @FXML
    private Label lblWarning;

    public void initialize() {

        lblWarning.setText("");

    }

    @FXML
    void addKategori(ActionEvent event) throws IOException {

        // push data to kategori table
        QueryKategori q = new QueryKategori();
        ArrayList<Kategori> ktable = q.getKategori();
        boolean hasExist = false;

        for (Kategori k : ktable) {

            if (kategoriForm.getText().equals(k.getNama_kategori())) {

                hasExist = true;
                break;

            }

        }

        if (hasExist == false) {

            Kategori k = new Kategori(kategoriForm.getText());
            q.addKategori(k);

            // automatically back to kategori view
            Parent newRoot = FXMLLoader.load(getClass().getResource("../../frontend/KategoriView.fxml"));
            btnAdd.getScene().setRoot(newRoot);

        } else {

            System.out.println("Kategori sudah ada di database!");
            lblWarning.setText("Kategori sudah ada di database!");

            kategoriForm.clear();

        }

    }

    @FXML
    void goToPrevious(ActionEvent event) throws IOException {

        Parent newRoot = FXMLLoader.load(getClass().getResource("../../frontend/KategoriView.fxml"));
        btnAdd.getScene().setRoot(newRoot);

    }

}
