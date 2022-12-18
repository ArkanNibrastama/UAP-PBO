package com.backend.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

public class HomeUserController {

    @FXML
    private Button btnBeliProduk;

    @FXML
    private Button btnLihatPesanan;

    @FXML
    void goToKatalog(ActionEvent event) throws IOException {

        Parent newRoot = FXMLLoader.load(getClass().getResource("../../frontend/Katalog.fxml"));
        btnBeliProduk.getScene().setRoot(newRoot);

    }

    @FXML
    void goToPesanan(ActionEvent event) throws IOException {

        Parent newRoot = FXMLLoader.load(getClass().getResource("../../frontend/Order.fxml"));
        btnLihatPesanan.getScene().setRoot(newRoot);

    }

}
