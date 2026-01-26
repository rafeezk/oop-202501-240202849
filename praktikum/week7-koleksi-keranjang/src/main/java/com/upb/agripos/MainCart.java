package com.upb.agripos;

public class MainCart {
    public static void main(String[] args) {
        System.out.println("Hello, I am Ahmad Rafie Ramadhani Azzaki - 240202849");
        System.out.println();

        Product p1 = new Product("P01", "Beras", 50000);
        Product p2 = new Product("P02", "Pupuk", 30000);

        ShoppingCart cart = new ShoppingCart();
        cart.tambahProduk(p1);
        cart.tambahProduk(p2);
        cart.tampilkanKeranjang();

        cart.hapusProduk(p1);
        cart.tampilkanKeranjang();

        ShoppingCartMap cartMap = new ShoppingCartMap();
        cartMap.tambahProduk(p1);
        cartMap.tambahProduk(p1);
        cartMap.tambahProduk(p2);
        cartMap.tampilkanKeranjang();
    }
}
