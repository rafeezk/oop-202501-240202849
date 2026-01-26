package com.upb.agripos.controller;

import com.upb.agripos.model.Product;
import com.upb.agripos.service.ProductService;

public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public Product addProduct(String code, String name, double price, int stock) {
        Product product = new Product(code, name, price, stock);
        productService.insert(product);
        return product;
    }
}
