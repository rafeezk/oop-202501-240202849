package com.upb.agripos.dao;

import com.upb.agripos.model.Product;

public class ProductDAOImpl implements ProductDAO {
    @Override
    public void insert(Product product) {
        System.out.println("Insert product: " + product.getName());
    }
}
