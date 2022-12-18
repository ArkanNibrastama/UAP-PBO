package com.backend.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.backend.Penjualan;
import com.backend.Produk;
import com.db.QueryPenjualan;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class OrderController {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnNext;

    @FXML
    private Label lblOrder;

    QueryPenjualan q = new QueryPenjualan();
    private ArrayList<Penjualan> pens = q.getPenjualan();
    private int c = 0;

    public void initialize(){

        String order = "";
        Penjualan pen = this.pens.get(0);
        int counter = 0;
        for (Produk p : pen.getProduk()){

            if (counter == 0){

                order = order + p.getNama_produk() + "(X" + p.getJumlah() + ")";

            }else{

                order = order + "\n" + p.getNama_produk() + "(X" + p.getJumlah() + ")";

            }

            counter += 1;

        }

        lblOrder.setText(order);

    }

    @FXML
    public void showOrder(int idx){

        String order = "";
        Penjualan pen = this.pens.get(idx);
        int counter = 0;
        for (Produk p : pen.getProduk()){

            if (counter == 0){

                order = order + p.getNama_produk() + "(X" + p.getJumlah() + ")";

            }else{

                order = order + "\n" + p.getNama_produk() + "(X" + p.getJumlah() + ")";

            }

            counter += 1;

        }

        lblOrder.setText(order);

    }

    @FXML
    void back(ActionEvent event) {
        if (this.c>0){

            this.c -= 1;

        }

        showOrder(this.c);
    }

    @FXML
    void deletePenjualan(ActionEvent event) throws IOException {

        Penjualan pen = this.pens.get(this.c);
        q.deletePenjualan(pen);

        //refresh
        Parent newRoot = FXMLLoader.load(getClass().getResource("../../frontend/Order.fxml"));
        btnCancel.getScene().setRoot(newRoot);

    }

    @FXML
    void next(ActionEvent event) {
        if (this.c < this.pens.size()-1){

            this.c += 1;

        }

        showOrder(this.c);
    }

}
