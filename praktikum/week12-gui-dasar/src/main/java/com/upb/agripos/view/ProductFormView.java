package com.upb.agripos.view;

import com.upb.agripos.controller.ProductController;
import com.upb.agripos.model.Product;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class ProductFormView extends VBox {
    public ProductFormView(ProductController controller) {
        TextField txtCode = new TextField();
        txtCode.setPromptText("Kode Produk");

        TextField txtName = new TextField();
        txtName.setPromptText("Nama Produk");

        TextField txtPrice = new TextField();
        txtPrice.setPromptText("Harga");

        TextField txtStock = new TextField();
        txtStock.setPromptText("Stok");

        Button btnAdd = new Button("Tambah Produk");
        ListView<String> listView = new ListView<>();

        btnAdd.setOnAction(e -> {
            try {
                Product p = controller.addProduct(
                    txtCode.getText(),
                    txtName.getText(),
                    Double.parseDouble(txtPrice.getText()),
                    Integer.parseInt(txtStock.getText())
                );
                listView.getItems().add(p.getCode() + " - " + p.getName());
            } catch (Exception ex) {
                new Alert(Alert.AlertType.ERROR, "Input tidak valid").show();
            }
        });

        getChildren().addAll(txtCode, txtName, txtPrice, txtStock, btnAdd, listView);
    }
}
