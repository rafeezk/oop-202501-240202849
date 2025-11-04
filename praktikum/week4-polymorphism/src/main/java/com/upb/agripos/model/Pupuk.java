package com.upb.agripos.model;

public class Pupuk extends Produk {
    private String jenis;

    public Pupuk(String nama, double harga, int stok, String jenis) {
        super(nama, harga, stok);
        this.jenis = jenis;
    }

    @Override
    public String getInfo() {
        return "Pupuk: " + nama + " (" + jenis + ") - Harga: Rp" + harga + " | Stok: " + stok;
    }
}
