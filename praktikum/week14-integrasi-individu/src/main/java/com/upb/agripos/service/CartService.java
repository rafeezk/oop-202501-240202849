package com.upb.agripos.service;

import com.upb.agripos.model.Cart;
import com.upb.agripos.model.CartItem;
import com.upb.agripos.model.Product;

public class CartService {
    private final Cart cart = new Cart();

    public void addItem(Product product, int qty) throws InvalidQuantityException {
        if (qty <= 0) {
            throw new InvalidQuantityException("Quantity harus lebih dari 0");
        }
        cart.addItem(product, qty);
    }

    public void removeItem(String code) {
        cart.removeItem(code);
    }

    public Cart getCart() {
        return cart;
    }

    public double getTotal() {
        return cart.getTotal();
    }
}