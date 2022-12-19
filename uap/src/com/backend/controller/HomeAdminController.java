package com.backend.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

public class HomeAdminController {

    @FXML
    private Button btnKategori;

    @FXML
    private Button btnProduk;

    @FXML
    private Button btnLogout;

    @FXML
    void goToKategoriView(ActionEvent event) throws IOException {

        Parent newRoot = FXMLLoader.load(getClass().getResource("../../frontend/KategoriView.fxml"));
        btnKategori.getScene().setRoot(newRoot);

    }

    @FXML
    void goToProdukView(ActionEvent event) throws IOException {

        Parent newRoot = FXMLLoader.load(getClass().getResource("../../frontend/ProdukView.fxml"));
        btnProduk.getScene().setRoot(newRoot);

    }

    @FXML
    void logout(ActionEvent event) throws IOException {

        Parent newRoot = FXMLLoader.load(getClass().getResource("../../frontend/Login.fxml"));
        btnProduk.getScene().setRoot(newRoot);

    }

}
