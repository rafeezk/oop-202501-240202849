package com.upb.agripos.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<String, CartItem> items = new HashMap<>(); // Menggunakan Map untuk Collections (Bab 7)

    public void addItem(Product product, int qty) {
        String code = product.getCode();
        if (items.containsKey(code)) {
            CartItem existing = items.get(code);
            existing.setQty(existing.getQty() + qty);
        } else {
            items.put(code, new CartItem(product, qty));
        }
    }

    public void removeItem(String code) {
        items.remove(code);
    }

    public Map<String, CartItem> getItems() {
        return items;
    }

    public double getTotal() {
        return items.values().stream().mapToDouble(item -> item.getProduct().getPrice() * item.getQty()).sum();
    }
}