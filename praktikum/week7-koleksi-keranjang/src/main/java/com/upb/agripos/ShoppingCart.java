package com.upb.agripos;

import java.util.ArrayList;

public class ShoppingCart {
    private final ArrayList<Product> items = new ArrayList<>();

    public void tambahProduk(Product p) {
        items.add(p);
    }

    public void hapusProduk(Product p) {
        items.remove(p);
    }

    public double hitungTotal() {
        double total = 0;
        for (Product p : items) {
            total += p.getPrice();
        }
        return total;
    }

    public void tampilkanKeranjang() {
        System.out.println("Isi Keranjang:");
        for (Product p : items) {
            System.out.println("- " + p.getCode() + " " + p.getName() + " = " + p.getPrice());
        }
        System.out.println("Total: " + hitungTotal());
        System.out.println();
    }
}
