package com.upb.agripos.service;

import com.upb.agripos.dao.ProductDAO;
import com.upb.agripos.model.Product;
import java.util.List;

public class ProductService {
    private final ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public void insert(Product product) throws Exception {
        if (product.getCode() == null || product.getCode().isEmpty()) {
            throw new InvalidInputException("Kode produk tidak boleh kosong");
        }
        if (product.getPrice() < 0) {
            throw new InvalidInputException("Harga tidak valid");
        }
        if (product.getStock() < 0) {
            throw new InvalidInputException("Stok tidak valid");
        }
        productDAO.insert(product);
    }

    public Product findByCode(String code) throws Exception {
        return productDAO.findByCode(code);
    }

    public List<Product> findAll() throws Exception {
        return productDAO.findAll();
    }

    public void update(Product product) throws Exception {
        productDAO.update(product);
    }

    public void delete(String code) throws Exception {
        productDAO.delete(code);
    }
}