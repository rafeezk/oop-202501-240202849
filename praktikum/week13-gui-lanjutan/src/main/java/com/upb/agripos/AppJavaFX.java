
package com.upb.agripos;
import com.upb.agripos.view.ProductTableView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class AppJavaFX extends Application{
    public void start(Stage s){
        s.setScene(new Scene(new ProductTableView(),600,400));
        s.setTitle("Agri-POS");
        s.show();
    }
    public static void main(String[] a){launch();}
}
