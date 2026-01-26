
package com.upb.agripos.controller;
import com.upb.agripos.model.Product;
import com.upb.agripos.service.ProductService;
import javafx.collections.*;
public class ProductController{
    private ProductService s=new ProductService();
    public ObservableList<Product> load(){
        return FXCollections.observableArrayList(s.findAll());
    }
    public void delete(Product p){s.delete(p.getCode());}
}
