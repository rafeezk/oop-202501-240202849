
package com.upb.agripos.view;
import com.upb.agripos.controller.ProductController;
import com.upb.agripos.model.Product;
import javafx.scene.control.*;import javafx.scene.layout.VBox;
import javafx.scene.control.cell.PropertyValueFactory;
public class ProductTableView extends VBox{
    private TableView<Product> t=new TableView<>();
    private ProductController c=new ProductController();
    public ProductTableView(){
        TableColumn<Product,String> k=new TableColumn<>("Kode");
        k.setCellValueFactory(new PropertyValueFactory<>("code"));
        TableColumn<Product,String> n=new TableColumn<>("Nama");
        n.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Product,Double> h=new TableColumn<>("Harga");
        h.setCellValueFactory(new PropertyValueFactory<>("price"));
        TableColumn<Product,Integer> s=new TableColumn<>("Stok");
        s.setCellValueFactory(new PropertyValueFactory<>("stock"));
        t.getColumns().addAll(k,n,h,s);
        Button d=new Button("Hapus Produk");
        d.setOnAction(e->{
            Product p=t.getSelectionModel().getSelectedItem();
            if(p!=null){c.delete(p);load();}
        });
        load();
        getChildren().addAll(t,d);
    }
    private void load(){t.setItems(c.load());}
}
