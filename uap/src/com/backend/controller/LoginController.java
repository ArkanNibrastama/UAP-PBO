package com.backend.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.db.QueryLogin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private Button btnLogin;

    @FXML
    private TextField formPassword;

    @FXML
    private TextField formUsername;

    @FXML
    private Label lblWarning;

    QueryLogin q = new QueryLogin();
    private ArrayList<String> usernames = q.getLogin().get(0);
    private ArrayList<String> passwords = q.getLogin().get(1);

    public void initialize() {

        lblWarning.setText("");

    }

    @FXML
    void login(ActionEvent event) throws IOException {

        boolean user = true, pass = true;

        for (int i = 0; i < this.usernames.size(); i++) {

            if (formUsername.getText().equals(usernames.get(i))) {

                if (formPassword.getText().equals(passwords.get(i))) {

                    if (usernames.get(i).equals("admin")) {

                        Parent newRoot = FXMLLoader.load(getClass().getResource("../../frontend/HomeAdmin.fxml"));
                        btnLogin.getScene().setRoot(newRoot);

                    } else {

                        Parent newRoot = FXMLLoader.load(getClass().getResource("../../frontend/HomeUser.fxml"));
                        btnLogin.getScene().setRoot(newRoot);

                    }

                    break;

                } else {

                    pass = false;

                }

                user = true;

            } else {

                user = false;

            }

        }

        if (user == false) {

            lblWarning.setText("Username yang Dimasukkan Salah!");

        }

        if (pass == false) {

            lblWarning.setText("Password yang Dimasukkan Salah!");

        }

    }

}
