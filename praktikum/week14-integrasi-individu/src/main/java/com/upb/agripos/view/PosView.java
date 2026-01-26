package com.upb.agripos.view;

import com.upb.agripos.controller.PosController;
import com.upb.agripos.model.Cart;
import com.upb.agripos.model.CartItem;
import com.upb.agripos.model.Product;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.List;

public class PosView extends Application {
    private PosController controller;
    private TableView<Product> productTable;
    private TextArea cartSummary;
    private ObservableList<Product> productList;

    @Override
    public void start(Stage primaryStage) {
        // Inisialisasi komponen GUI
        productTable = new TableView<>();
        TableColumn<Product, String> codeCol = new TableColumn<>("Kode");
        codeCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getCode()));
        TableColumn<Product, String> nameCol = new TableColumn<>("Nama");
        nameCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getName()));
        TableColumn<Product, Double> priceCol = new TableColumn<>("Harga");
        priceCol.setCellValueFactory(data -> new javafx.beans.property.SimpleDoubleProperty(data.getValue().getPrice()).asObject());
        TableColumn<Product, Integer> stockCol = new TableColumn<>("Stok");
        stockCol.setCellValueFactory(data -> new javafx.beans.property.SimpleIntegerProperty(data.getValue().getStock()).asObject());
        productTable.getColumns().addAll(codeCol, nameCol, priceCol, stockCol);
        productList = FXCollections.observableArrayList();
        productTable.setItems(productList);

        // Form tambah produk
        TextField codeField = new TextField();
        codeField.setPromptText("Kode");
        TextField nameField = new TextField();
        nameField.setPromptText("Nama");
        TextField priceField = new TextField();
        priceField.setPromptText("Harga");
        TextField stockField = new TextField();
        stockField.setPromptText("Stok");
        Button addButton = new Button("Tambah Produk");
        addButton.setOnAction(e -> {
            try {
                String code = codeField.getText();
                String name = nameField.getText();
                double price = Double.parseDouble(priceField.getText());
                int stock = Integer.parseInt(stockField.getText());
                controller.addProduct(code, name, price, stock);
                codeField.clear();
                nameField.clear();
                priceField.clear();
                stockField.clear();
            } catch (NumberFormatException ex) {
                showError("Input harga atau stok tidak valid");
            }
        });

        // Tombol hapus produk
        Button deleteButton = new Button("Hapus Produk");
        deleteButton.setOnAction(e -> {
            Product selected = productTable.getSelectionModel().getSelectedItem();
            if (selected != null) {
                controller.deleteProduct(selected.getCode());
            } else {
                showError("Pilih produk untuk dihapus");
            }
        });

        // Keranjang
        cartSummary = new TextArea();
        cartSummary.setEditable(false);
        Button addToCartButton = new Button("Tambah ke Keranjang");
        addToCartButton.setOnAction(e -> {
            Product selected = productTable.getSelectionModel().getSelectedItem();
            if (selected != null) {
                controller.addToCart(selected, 1); // Qty default 1
            } else {
                showError("Pilih produk untuk ditambahkan ke keranjang");
            }
        });

        VBox layout = new VBox(10, productTable, codeField, nameField, priceField, stockField, addButton, deleteButton, addToCartButton, cartSummary);
        Scene scene = new Scene(layout, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Agri-POS");
        primaryStage.show();

        controller.loadProducts();
    }

    public void setController(PosController controller) {
        this.controller = controller;
    }

    public void displayProducts(List<Product> products) {
        productList.clear();
        productList.addAll(products);
    }

    public void updateCartSummary(Cart cart) {
        StringBuilder sb = new StringBuilder("Keranjang:\n");
        for (CartItem item : cart.getItems().values()) {
            sb.append(item.getProduct().getName()).append(" x").append(item.getQty()).append(" = ").append(item.getProduct().getPrice() * item.getQty()).append("\n");
        }
        sb.append("Total: ").append(cart.getTotal());
        cartSummary.setText(sb.toString());
    }

    public void showMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.show();
    }

    public void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.show();
    }
}