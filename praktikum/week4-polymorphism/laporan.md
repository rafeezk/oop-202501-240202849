# 🧩 Laporan Praktikum Minggu 4
## Topik: Polymorphism dan Method Overloading dalam OOP Java

---

### 🧑‍🎓 Identitas
**Nama:** Ahmad Rafie Ramadhani Azzaki 
**NIM:** 240202849
**Kelas:** 3IKRA

---

### 🎯 Tujuan Pembelajaran

- Mahasiswa memahami konsep polymorphism.
- Mahasiswa mampu mengimplementasikan inheritance pada class turunan.
- Mahasiswa mampu menerapkan method overloading.
- Mahasiswa dapat menampilkan informasi produk sesuai jenis objek.

---

### 📚 Dasar Teori:

- Polymorphism memungkinkan objek memiliki bentuk/perilaku berbeda walaupun referensinya sama.
- Inheritance membuat class turunan mewarisi atribut dan method parent.
- Overriding: mendefinisikan ulang method parent di child class.
- Overloading: method dengan nama sama tetapi parameter berbeda.
- Array of Object dapat menampung berbagai objek turunan.

### 🧪 Langkah Praktikum

- Setup project Java menggunakan struktur package com.upb.agripos.
- Membuat class Produk sebagai parent.
- Membuat class turunan: Pupuk, Benih, AlatPertanian, ObatHama.
- Mengimplementasikan overriding pada method getInfo().
- Mengimplementasikan overloading pada method tambahStok().
- Menjalankan class MainPolymorphism untuk mengetes program.
- Menambahkan stok menggunakan overloading parameter.
- Commit message: "Implement Polymorphism & Overloading pada class Produk dan turunannya".

---

## 💻 Kode Program

#### `AlatPertanian.java`
```java
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
```

#### `Benih.java`
```java
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
```

#### `ObatHama.java`
```java
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
```

#### `Produk.java`
```java
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
```

#### `Pupuk.java`
```java
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
```

#### `MainPolymorphism.java`
```java
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
```

---

## 📸 Hasil Eksekusi 

<img width="1920" height="1080" alt="Screenshot (469)" src="https://github.com/user-attachments/assets/82feeb77-3f9d-41fc-8882-7c1ba9bd2788" />

---

## 🔍 Analisis

- Polymorphism bekerja ketika array Produk[] menyimpan objek dari class turunan, tetapi method getInfo() tetap mengikuti implementasi class child.
- Overloading terjadi pada method tambahStok() dengan dua parameter berbeda.
- Dibanding minggu sebelumnya, fokus praktikum ini pada hubungan antar class, bukan class tunggal.
- Kendala: struktur package harus sesuai, penggunaan overriding harus tepat, pemahaman referensi parent-child diperlukan.
- Solusi: memastikan folder sesuai package, menggunakan @Override, memanggil super() pada konstruktor.

---

## 🧭 Kesimpulan  

- Praktikum memberikan pemahaman tentang polymorphism, inheritance, overriding, dan overloading.
- Polymorphism membuat kode lebih fleksibel dan mudah dikembangkan.
- Overloading mempermudah penggunaan method dengan fungsi berbeda.
- Program menjadi lebih terstruktur dengan pendekatan OOP.

---

## 💡 Quiz

### 1. Apa perbedaan overloading dan overriding?
**Jawaban:**  
- Overloading adalah membuat beberapa method dengan nama yang sama tetapi parameter berbeda (jumlah atau tipe). Terjadi dalam satu class yang sama.
- Overriding adalah mendefinisikan ulang method yang sama dari parent class pada class child. Terjadi pada class turunan untuk mengubah perilaku bawaan parent.

### 2. Bagaimana Java menentukan method mana yang dipanggil dalam dynamic binding?"
**Jawaban:**
Java menggunakan tipe objek sebenarnya (runtime object) untuk menentukan method mana yang dipanggil. Meskipun referensinya bertipe parent, Java akan mengeksekusi method milik class child jika terjadi overriding.

Contoh :
```java
Produk p = new Pupuk("NPK", 50000, 10, "Organik");
p.getInfo(); // yang dipanggil adalah getInfo() milik class Pupuk
```
### 3. Berikan contoh kasus polymorphism dalam sistem POS selain produk pertanian
**Jawaban:**
Contoh polymorphism dalam Sistem POS (Point of Sale) adalah pada item transaksi seperti:

**Class Parent :** 
- Item
- Nama item
- Harga

**Class Turunan :**
- MakananMinuman → memiliki atribut tanggal kadaluarsa
- Elektronik → memiliki atribut garansi
- Pakaian → memiliki atribut ukuran
- JasaService → memiliki atribut durasi layanan

**Semua class memiliki method yang dioverride :**
```java
public String getInfo()
```

**Saat disimpan dalam array :**
```java
Item[] daftarItem = {
    new MakananMinuman("Roti", 15000, "2026-01-01"),
    new Elektronik("Headset", 250000, "12 Bulan"),
    new Pakaian("Kaos Polos", 50000, "L"),
    new JasaService("Service Laptop", 150000, 2)
};

for (Item i : daftarItem) {
    System.out.println(i.getInfo());
}
```
