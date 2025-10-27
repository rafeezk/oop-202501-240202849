# Laporan Praktikum Minggu 3  
## Topik: Inheritance (Kategori Produk)

---

### Identitas
**Nama:** Ahmad Rafie Ramadhani Azzaki 
**NIM:** 240202849
**Kelas:** 3IKRA

---

### Tujuan Pembelajaran
- Mahasiswa mampu menjelaskan konsep inheritance (pewarisan class) dalam OOP.  
- Mahasiswa mampu membuat superclass dan subclass untuk produk pertanian.  
- Mahasiswa mampu mendemonstrasikan hierarki class melalui contoh kode.  
- Mahasiswa mampu menggunakan `super` untuk memanggil konstruktor dan method parent class.  
- Mahasiswa mampu membuat laporan praktikum yang menjelaskan perbedaan penggunaan inheritance dibanding class tunggal.

---

### Ringkasan Teori
1. **Inheritance** adalah mekanisme dalam OOP yang memungkinkan suatu class mewarisi atribut dan method dari class lain.  
2. **Superclass** adalah class induk yang mendefinisikan atribut umum.  
3. **Subclass** adalah class turunan yang mewarisi atribut/method superclass dan dapat menambahkan atribut/method baru.  
4. Keyword **`super`** digunakan untuk memanggil konstruktor atau method dari superclass.  
5. Dalam konteks **Agri-POS**, class `Produk` dapat dijadikan superclass, sedangkan `Benih`, `Pupuk`, dan `AlatPertanian` menjadi subclass. Hal ini membuat kode lebih reusable, modular, dan mudah diperluas.

---

### Langkah Praktikum

1. **Membuat Superclass `Produk`**
   - Gunakan class `Produk` dari Bab 2 sebagai superclass utama.

2. **Membuat Subclass**
   - `Benih.java` → atribut tambahan: `varietas`.  
   - `Pupuk.java` → atribut tambahan: `jenis`.  
   - `AlatPertanian.java` → atribut tambahan: `material`.

3. **Membuat Main Class**
   - Instansiasi minimal satu objek dari tiap subclass.
   - Tampilkan data produk dengan memanfaatkan inheritance.

4. **Menambahkan CreditBy**
   - Panggil class `CreditBy` untuk menampilkan identitas mahasiswa.

5. **Commit dan Push**
   - Commit dengan pesan: `week3-inheritance`.

---

## 💻 Kode Program  

#### `Benih.java`
```java
package com.upb.agripos.model;

public class Benih extends Produk {
    private String varietas;

    public Benih(String kode, String nama, double harga, int stok, String varietas) {
        super(kode, nama, harga, stok);
        this.varietas = varietas;
    }

    public String getVarietas() { return varietas; }
    public void setVarietas(String varietas) { this.varietas = varietas; }
}
```

#### `Pupuk.java`
```java
package com.upb.agripos.model;

public class Pupuk extends Produk {
    private String jenis;

    public Pupuk(String kode, String nama, double harga, int stok, String jenis) {
        super(kode, nama, harga, stok);
        this.jenis = jenis;
    }

    public String getJenis() { return jenis; }
    public void setJenis(String jenis) { this.jenis = jenis; }
}
```

#### `AlatPertanian.java`
```java
package com.upb.agripos.model;

public class AlatPertanian extends Produk {
    private String material;

    public AlatPertanian(String kode, String nama, double harga, int stok, String material) {
        super(kode, nama, harga, stok);
        this.material = material;
    }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }
}
```

#### `MainInharitance.java`
```java
package com.upb.agripos;

import com.upb.agripos.model.*;
import com.upb.agripos.util.CreditBy;

public class MainInheritance {
    public static void main(String[] args) {
        Benih b = new Benih("BNH-001", "Benih Padi IR64", 25000, 100, "IR64");
        Pupuk p = new Pupuk("PPK-101", "Pupuk Urea", 350000, 40, "Urea");
        AlatPertanian a = new AlatPertanian("ALT-501", "Cangkul Baja", 90000, 15, "Baja");

        System.out.println("Benih: " + b.getNama() + " | Varietas: " + b.getVarietas());
        System.out.println("Pupuk: " + p.getNama() + " | Jenis: " + p.getJenis());
        System.out.println("Alat Pertanian: " + a.getNama() + " | Material: " + a.getMaterial());

        CreditBy.print("<NIM>", "<Nama Mahasiswa>");
    }
}
```

---

## 📸 Hasil Eksekusi 

<img width="1920" height="1080" alt="Screenshot (458)" src="https://github.com/user-attachments/assets/53a15418-41ca-49e1-bf93-f8d8bea391c0" />

---

## 🔍 Analisis  

Kode di atas menunjukkan bahwa subclass (`Benih`, `Pupuk`, `AlatPertanian`) **mewarisi atribut dan method dari superclass `Produk`**.

Dengan menggunakan **inheritance**, tidak perlu menulis ulang atribut seperti `kode`, `nama`, `harga`, dan `stok` di setiap subclass.  
Penggunaan `super()` memungkinkan subclass memanggil konstruktor milik superclass, sehingga proses inisialisasi data produk tetap konsisten dan terjaga.  

Pendekatan ini jauh lebih **efisien** dibanding membuat class terpisah tanpa hubungan karena:  
- Dapat memanfaatkan kembali logika dan atribut umum dari superclass.  
- Mempermudah pemeliharaan dan pengembangan sistem.  
- Mengurangi duplikasi kode (code redundancy).  

Kendala yang sering dihadapi biasanya terkait dengan:  
- Pemahaman konsep pewarisan antar class.  
- Cara pemanggilan konstruktor `super()` secara tepat.  
- Pengelolaan atribut tambahan di subclass agar tidak bertentangan dengan atribut superclass.  

---

## 🧭 Kesimpulan  

Dengan menggunakan **inheritance**, program menjadi lebih **terstruktur**, **modular**, dan **mudah dikembangkan**.  
Superclass menyimpan atribut umum yang dapat digunakan kembali oleh seluruh subclass, sedangkan subclass menangani detail spesifik dari tiap jenis produk pertanian.  

Konsep ini sangat membantu dalam pengembangan sistem besar seperti **Agri-POS**, karena:  
- Memudahkan ekspansi jenis produk baru.  
- Mengurangi kompleksitas kode.  
- Menjaga konsistensi antar class turunan.  

---

## 💡 Quiz

### 1. Apa keuntungan menggunakan inheritance dibanding membuat class terpisah tanpa hubungan?
**Jawaban:**  
Inheritance mengurangi duplikasi kode dan meningkatkan keteraturan dengan menyatukan atribut serta perilaku umum di superclass.  
Selain itu, perubahan di superclass akan langsung berpengaruh ke seluruh subclass, sehingga pemeliharaan menjadi lebih mudah.

---

### 2. Bagaimana cara subclass memanggil konstruktor superclass?
**Jawaban:**  
Subclass menggunakan keyword **`super()`** di dalam konstruktor untuk memanggil konstruktor dari superclass.  
Contoh:
```java
public class Benih extends Produk {
    public Benih(String kode, String nama, double harga, int stok, String varietas) {
        super(kode, nama, harga, stok);
        this.varietas = varietas;
    }
}
```
---

### 3. Berikan contoh kasus di POS pertanian selain Benih, Pupuk, dan Alat Pertanian yang bisa dijadikan subclass
**Jawaban:**
Beberapa contoh subclass tambahan yang bisa dibuat:

- **ObatHama** → memiliki atribut *jenis bahan aktif* dan *dosis*.
- **BibitTernak** → memiliki atribut *ras* dan *umur*.
- **PeralatanIrigasi** → memiliki atribut *kapasitas* dan *bahan*.

Subclass tersebut dapat mewarisi atribut umum dari `Produk`, sambil menambahkan atribut spesifik sesuai karakteristiknya.

---
