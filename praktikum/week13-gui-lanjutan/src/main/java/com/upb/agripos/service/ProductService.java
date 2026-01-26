
package com.upb.agripos.service;
import com.upb.agripos.dao.ProductDAO;
import com.upb.agripos.model.Product;
import java.util.*;
public class ProductService{
    private ProductDAO dao=new ProductDAO();
    public List<Product> findAll(){return dao.findAll();}
    public void delete(String code){dao.delete(code);}
}
