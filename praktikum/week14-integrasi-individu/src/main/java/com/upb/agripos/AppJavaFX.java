package com.upb.agripos;

import com.upb.agripos.controller.PosController;
import com.upb.agripos.dao.JdbcProductDAO;
import com.upb.agripos.service.CartService;
import com.upb.agripos.service.ProductService;
import com.upb.agripos.view.PosView;
import javafx.application.Application;

import java.sql.Connection;
import java.sql.DriverManager;

public class AppJavaFX extends Application {
    @Override
    public void start(javafx.stage.Stage primaryStage) {
        // Identitas Bab 1
        System.out.println("Hello World, I am [Nama]-[NIM]");

        try {
            // Singleton untuk koneksi DB (Pattern Bab 10)
            Connection connection = DatabaseConnection.getInstance();
            ProductDAO productDAO = new JdbcProductDAO(connection);
            ProductService productService = new ProductService(productDAO);
            CartService cartService = new CartService();
            PosView view = new PosView();
            PosController controller = new PosController(productService, cartService, view);
            view.setController(controller);
            view.start(primaryStage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

// Singleton Pattern untuk koneksi DB
class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection() throws Exception {
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/agripos", "username", "password");
    }

    public static Connection getInstance() throws Exception {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance.connection;
    }
}