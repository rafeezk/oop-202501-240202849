package com.upb.agripos;

import com.upb.agripos.model.*;
import com.upb.agripos.util.CreditBy;

public class MainPolymorphism {

    public static void main(String[] args) {
        Produk[] daftarProduk = new Produk[4];
        daftarProduk[0] = new Pupuk("NPK Super", 75000, 20, "Organik");
        daftarProduk[1] = new Benih("Benih Padi Unggul", 50000, 30, "Padi");
        daftarProduk[2] = new AlatPertanian("Cangkul Baja", 120000, 15, "Menggemburkan tanah");
        daftarProduk[3] = new ObatHama("AntiTikusHama", 60000, 25, "Tikus");

        for (Produk p : daftarProduk) {
            System.out.println(p.getInfo());
        }

        System.out.println("\n=== Demonstrasi Overloading ===");
        daftarProduk[0].tambahStok(10, true);
        daftarProduk[1].tambahStok(5, true);

        System.out.println("\n=== Setelah Tambah Stok ===");
        for (Produk p : daftarProduk) {
            System.out.println(p.getInfo());
        }

        CreditBy.print("240202849", "Ahmad Rafie Ramadhani Azzaki");
    }
   
}
