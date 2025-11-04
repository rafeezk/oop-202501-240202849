package com.upb.agripos.model;

public class Produk {
    protected String nama;
    protected double harga;
    protected int stok;

    public Produk(String nama, double harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // Method overloading: tambahStok()
    public void tambahStok(int jumlah) {
        stok += jumlah;
    }

    public void tambahStok(int jumlah, boolean cetak) {
        stok += jumlah;
        if (cetak) {
            System.out.println(jumlah + " stok telah ditambahkan ke " + nama);
        }
    }

    public String getInfo() {
        return "Produk: " + nama + " | Harga: Rp" + harga + " | Stok: " + stok;
    }
}
