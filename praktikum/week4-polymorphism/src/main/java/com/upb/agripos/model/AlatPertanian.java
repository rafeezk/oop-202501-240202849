package com.upb.agripos.model;

public class AlatPertanian extends Produk {
    private String fungsi;

    public AlatPertanian(String nama, double harga, int stok, String fungsi) {
        super(nama, harga, stok);
        this.fungsi = fungsi;
    }

    @Override
    public String getInfo() {
        return "Alat Pertanian: " + nama + " | Fungsi: " + fungsi + " | Harga: Rp" + harga + " | Stok: " + stok;
    }
}

