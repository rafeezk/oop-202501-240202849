# 🧪 Laporan Praktikum Minggu 2  
## Topik: Class dan Object (Produk Pertanian)

---

### 👤 Identitas  
- **Nama:** Ahmad Rafie Ramadhani Azzaki  
- **NIM:** 240202849  
- **Kelas:** 3IKRA  

---

### 🎯 Tujuan  
Mahasiswa memahami konsep *class* dan *object* dalam pemrograman berorientasi objek, serta dapat mengimplementasikan konsep **enkapsulasi** melalui pembuatan class `Produk` dan `CreditBy`.  
Selain itu, mahasiswa mampu mempraktikkan relasi antar objek melalui program simulasi data produk pertanian.

---

### 🧠 Dasar Teori  
1. **Class** adalah blueprint atau cetak biru dari objek yang mendefinisikan atribut dan perilakunya.  
2. **Object** adalah instance nyata dari class yang memiliki nilai konkret.  
3. **Enkapsulasi** menyembunyikan detail data internal dari luar class agar lebih aman dan terkontrol.  
4. **Constructor** digunakan untuk menginisialisasi nilai awal atribut saat objek dibuat.  
5. **Getter dan Setter** berfungsi untuk mengakses dan memodifikasi atribut private sesuai prinsip enkapsulasi.

---

### ⚙️ Langkah Praktikum  

1. **Persiapan dan Setup**
   - Pastikan JDK sudah terinstal.
   - Buka editor seperti Visual Studio Code.
   - Buat folder proyek bernama `ProdukPertanian`.

2. **Pembuatan File**
   - `Produk.java` → berisi definisi class produk dengan atribut `kode`, `nama`, `harga`, dan `stok`.  
   - `CreditBy.java` → menampilkan identitas pembuat program.  
   - `MainProduk.java` → sebagai *main class* untuk menjalankan dan menampilkan data produk.

3. **Langkah Eksekusi**
   - Kompilasi semua file:
     ```bash
     javac *.java
     ```
   - Jalankan program utama:
     ```bash
     java MainProduk
     ```

4. **Commit Message Git**
   - `feat: implement class Produk and CreditBy with encapsulation`
   - `chore: add main class to display product data`

---

### 💻 Kode Program  

#### `Produk.java`
```java
public class Produk {
    private String kode;
    private String nama;
    private double harga;
    private int stok;

    public Produk(String kode, String nama, double harga, int stok) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public String getKode() { return kode; }
    public String getNama() { return nama; }
    public double getHarga() { return harga; }
    public int getStok() { return stok; }

    public void setStok(int stok) { this.stok = stok; }

    public void tampilInfo() {
        System.out.println("Kode Produk  : " + kode);
        System.out.println("Nama Produk  : " + nama);
        System.out.println("Harga Produk : Rp" + harga);
        System.out.println("Stok Produk  : " + stok);
    }
}
```

#### `CreditBy.java
```java
public class CreditBy {
    private String nama;
    private String nim;
    private String kelas;

    public CreditBy(String nama, String nim, String kelas) {
        this.nama = nama;
        this.nim = nim;
        this.kelas = kelas;
    }

    public void tampilCredit() {
        System.out.println("\nDikembangkan oleh:");
        System.out.println("Nama  : " + nama);
        System.out.println("NIM   : " + nim);
        System.out.println("Kelas : " + kelas);
    }
}
```

#### `MainProduk.java`
```java
public class MainProduk {
    public static void main(String[] args) {
        Produk p1 = new Produk("BNH-001", "Benih Padi", 25000, 100);
        Produk p2 = new Produk("PNH-002", "Pupuk NPK", 80000, 50);

        p1.tampilInfo();
        System.out.println();
        p2.tampilInfo();

        CreditBy dev = new CreditBy("Ahmad Rafie Ramadhani Azzaki", "240202849", "3IKRA");
        dev.tampilCredit();
    }
}
```

### 🖼️ Screenshot



## 🔍 Analisis

Program ini menggunakan tiga **class utama**:

- **Produk** → merepresentasikan entitas produk pertanian.  
- **CreditBy** → menampilkan identitas pengembang.  
- **MainProduk** → berisi `main()` method untuk menjalankan program utama.  

Konsep **enkapsulasi** diterapkan dengan mendeklarasikan atribut sebagai `private` dan menyediakan metode `getter` dan `setter` untuk mengakses serta memodifikasinya.  

Pendekatan **Object-Oriented Programming (OOP)** yang digunakan memisahkan logika bisnis ke dalam beberapa class sehingga kode menjadi lebih **modular, terstruktur, dan mudah dipelihara**.  

Jika dibandingkan dengan pendekatan **prosedural** pada minggu sebelumnya, struktur program minggu ini jauh lebih fleksibel, mudah dikembangkan, dan mendukung ekspansi fitur di masa depan.  

> ⚠️ **Kendala:** Pastikan semua file (`Produk.java`, `CreditBy.java`, dan `MainProduk.java`) berada dalam satu folder yang sama agar dapat dikenali oleh compiler Java.

---

## 🧩 Kesimpulan

Dengan menerapkan konsep **class** dan **object**, program menjadi lebih **terorganisir, aman, dan mudah dikembangkan**.  
Konsep **enkapsulasi** memastikan bahwa data produk tidak dapat diubah secara langsung dari luar class, sehingga meningkatkan **keamanan dan konsistensi data**.

---

## 📝 Quiz

### 1. Mengapa atribut sebaiknya dideklarasikan sebagai `private` dalam class?
**Jawaban:**  
Agar data tidak dapat diakses atau diubah secara langsung dari luar class. Hal ini menjaga integritas data dan memungkinkan pengembang mengontrol bagaimana atribut dimodifikasi melalui metode tertentu (*getter* dan *setter*).

---

### 2. Apa fungsi getter dan setter dalam enkapsulasi?
**Jawaban:**  
`Getter` berfungsi untuk mengambil nilai atribut `private`, sedangkan `Setter` digunakan untuk mengubah nilainya secara terkontrol. Dengan cara ini, akses terhadap atribut menjadi lebih aman dan sesuai dengan aturan bisnis yang ditentukan.

---

### 3. Bagaimana cara class `Produk` mendukung pengembangan aplikasi POS yang lebih kompleks?
**Jawaban:**  
Class `Produk` dapat dijadikan fondasi untuk sistem **Point of Sale (POS)** dengan menambahkan fitur seperti:
- Penghitungan total harga secara otomatis,  
- Manajemen stok barang,  
- Integrasi dengan modul transaksi dan laporan penjualan.  

Struktur class yang rapi dan modular membuat `Produk` mudah diintegrasikan dalam aplikasi yang lebih besar.

---
