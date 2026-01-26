package com.upb.agripos;

import com.upb.agripos.controller.ProductController;
import com.upb.agripos.dao.ProductDAO;
import com.upb.agripos.dao.ProductDAOImpl;
import com.upb.agripos.service.ProductService;
import com.upb.agripos.view.ProductFormView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppJavaFX extends Application {
    @Override
    public void start(Stage stage) {
        ProductDAO dao = new ProductDAOImpl();
        ProductService service = new ProductService(dao);
        ProductController controller = new ProductController(service);

        stage.setScene(new Scene(new ProductFormView(controller), 400, 400));
        stage.setTitle("Agri-POS - GUI Produk");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
