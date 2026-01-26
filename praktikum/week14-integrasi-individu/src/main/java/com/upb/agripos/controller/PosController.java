package com.upb.agripos.controller;

import com.upb.agripos.model.Product;
import com.upb.agripos.service.ProductService;
import com.upb.agripos.service.CartService;
import com.upb.agripos.view.PosView;
import java.util.List;

public class PosController {
    private final ProductService productService;
    private final CartService cartService;
    private final PosView view;

    public PosController(ProductService productService, CartService cartService, PosView view) {
        this.productService = productService;
        this.cartService = cartService;
        this.view = view;
    }

    public void loadProducts() {
        try {
            List<Product> products = productService.findAll();
            view.displayProducts(products);
        } catch (Exception e) {
            view.showError(e.getMessage());
        }
    }

    public void addProduct(String code, String name, double price, int stock) {
        try {
            Product product = new Product(code, name, price, stock);
            productService.insert(product);
            loadProducts();
            view.showMessage("Produk berhasil ditambahkan");
        } catch (Exception e) {
            view.showError(e.getMessage());
        }
    }

    public void deleteProduct(String code) {
        try {
            productService.delete(code);
            loadProducts();
            view.showMessage("Produk berhasil dihapus");
        } catch (Exception e) {
            view.showError(e.getMessage());
        }
    }

    public void addToCart(Product product, int qty) {
        try {
            cartService.addItem(product, qty);
            view.updateCartSummary(cartService.getCart());
            view.showMessage("Item ditambahkan ke keranjang");
        } catch (Exception e) {
            view.showError(e.getMessage());
        }
    }

    public void removeFromCart(String code) {
        cartService.removeItem(code);
        view.updateCartSummary(cartService.getCart());
        view.showMessage("Item dihapus dari keranjang");
    }
}