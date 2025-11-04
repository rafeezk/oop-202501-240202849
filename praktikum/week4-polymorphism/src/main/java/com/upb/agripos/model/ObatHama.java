package com.upb.agripos.model;

public class ObatHama extends Produk {
    private String targetHama;

    public ObatHama(String nama, double harga, int stok, String targetHama) {
        super(nama, harga, stok);
        this.targetHama = targetHama;
    }

    @Override
    public String getInfo() {
        return "Obat Hama: " + nama + " | Target: " + targetHama + " | Harga: Rp" + harga + " | Stok: " + stok;
    }
}