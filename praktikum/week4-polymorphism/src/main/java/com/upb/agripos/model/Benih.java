package com.upb.agripos.model;

public class Benih extends Produk {
    private String tanaman;

    public Benih(String nama, double harga, int stok, String tanaman) {
        super(nama, harga, stok);
        this.tanaman = tanaman;
    }

    @Override
    public String getInfo() {
        return "Benih " + tanaman + " - " + nama + " | Harga: Rp" + harga + " | Stok: " + stok;
    }
}
