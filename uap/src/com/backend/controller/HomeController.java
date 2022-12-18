package com.backend.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

public class HomeController {

    @FXML
    private Button btnAdmin;

    @FXML
    private Button btnUser;

    @FXML
    void goToHomeAdmin(ActionEvent event) throws IOException {

        Parent newRoot = FXMLLoader.load(getClass().getResource("../../frontend/HomeAdmin.fxml"));
        btnAdmin.getScene().setRoot(newRoot);

    }

    @FXML
    void goToHomeUser(ActionEvent event) throws IOException {

        Parent newRoot = FXMLLoader.load(getClass().getResource("../../frontend/HomeUser.fxml"));
        btnAdmin.getScene().setRoot(newRoot);

    }

}
