# 🧪 Laporan Praktikum Minggu 1  
**Topik:** Pengenalan paradigma pemrograman dalam Java.
## Identitas
- Nama  : Ahmad Rafie Ramadhani Azzaki
- NIM   : 240202849
- Kelas : 240202849

---

## 🎯 Tujuan
Praktikum ini bertujuan agar mahasiswa mampu memahami dan membedakan tiga paradigma utama dalam pemrograman Java, yaitu **Prosedural**, **Berorientasi Objek (OOP)**, dan **Fungsional**.  
Melalui program sederhana “Hello World, I am [nama]-[nim]”, mahasiswa diharapkan memahami bagaimana setiap paradigma mempengaruhi struktur kode, cara berpikir, dan cara mengelola logika program.

---

## 📚 Dasar Teori
1. **Paradigma Prosedural** berfokus pada langkah-langkah eksekusi yang disusun secara berurutan (top-down).
2. **Paradigma OOP (Object-Oriented Programming)** menggunakan konsep objek dan class untuk mengorganisasikan data serta perilaku.
3. **Paradigma Fungsional** menekankan fungsi murni dan ekspresi deklaratif menggunakan *lambda expression* dan *Stream API*.
4. Java merupakan bahasa **multiparadigma** yang mendukung ketiganya sekaligus.
5. Pemilihan paradigma akan memengaruhi efisiensi, skalabilitas, dan keterbacaan program.

---

## ⚙️ Langkah Praktikum

### 1️⃣ Setup
- Memastikan **JDK (Java Development Kit)** telah terpasang menggunakan perintah `java -version`.
- Menyiapkan **IDE** seperti *VS Code*, *IntelliJ IDEA*, atau *Eclipse*.
- Membuat struktur direktori: praktikum/week1-setup-hello-pos/src/main/java/com/upb/agripos/

### 2️⃣ Implementasi Paradigma Prosedural
- Membuat file `HelloProcedural.java`.
- Menuliskan kode di dalam method `main()` tanpa class tambahan.
- Menambahkan variabel `nama` dan `nim`, kemudian mencetak hasil dengan `System.out.println()`.
- Menjalankan program untuk memastikan hasil tampil dengan benar.

### 3️⃣ Implementasi Paradigma OOP
- Membuat file `HelloOOP.java`.
- Menulis class `Mahasiswa` dengan atribut `nama` dan `nim`.
- Menambahkan constructor dan method `sapa()` untuk mencetak hasil.
- Membuat objek `Mahasiswa` dan memanggil `sapa()` dalam `main()`.
- Mengamati struktur kode yang lebih modular dibandingkan versi prosedural.

### 4️⃣ Implementasi Paradigma Fungsional
- Membuat file `HelloFunctional.java`.
- Mengimpor `java.util.function.BiConsumer`.
- Menggunakan *lambda expression* untuk mendefinisikan fungsi `sayHello`.
- Memanggil fungsi tersebut menggunakan `accept(nama, nim)`.

---

## 💻 Kode Program

### 🟦 HelloProcedural.java

```java
public class HelloProcedural {
    public static void main(String[] args) {
        String nama = "Ahmad Rafie Ramadhani Azzaki";
        String nim = "240202849";

        System.out.println("Hello World, I am " + nama + " - " + nim);
    }
}
```
### 🟩 HelloOOP.java

```java
class Mahasiswa {
    String nama;
    String nim;

    Mahasiswa(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    void sayHello() {
        System.out.println("Hello World, I am " + nama + " - " + nim);
    }
}

public class HelloOOP {
    public static void main(String[] args) {
        Mahasiswa mhs = new Mahasiswa("Ahmad Rafie Ramadhani Azzaki", "240202849");
        mhs.sayHello();
    }
}
```

### 🟨 HelloFunctional.java

```java
public class HelloFunctional {
    public static void main(String[] args) {
        String nama = "Ahmad Rafie Ramadhani Azzaki";
        String nim = "240202849";

        BiConsumer<String, String> sayHello = (n, i) ->
                System.out.println("Hello World, I am " + n + "-" + i);

        sayHello.accept(nama, nim);
    }
}
```

---

## 📸 Hasil Eksekusi

### 🟦 HelloProcedural.java
<img width="1920" height="1080" alt="resultshellooop" src="https://github.com/user-attachments/assets/5434a0df-0221-4d15-a02c-c0e51d0b7c01" />

### 🟩 HelloOOP.java
<img width="1920" height="1080" alt="resultshelloprocedural" src="https://github.com/user-attachments/assets/7f886b34-299a-4d1e-814d-fbc8cc2c6712" />

### 🟨 HelloFunctional.java
<img width="1920" height="1080" alt="resultshellofunctional" src="https://github.com/user-attachments/assets/61860422-ef73-482e-b212-54043a510bca" />

---

## 🔍 Analisis

- Pendekatan Prosedural mudah dipahami dan efisien untuk program sederhana, tetapi kurang fleksibel jika program berkembang menjadi besar.
- OOP memperkenalkan konsep class dan objek, menjadikan kode lebih terstruktur, modular, dan mudah dipelihara.
- Pendekatan Fungsional menawarkan gaya deklaratif dan ringkas, cocok untuk tugas pemrosesan data atau logika yang tidak membutuhkan state.
- Ketiga paradigma memiliki keunggulan masing-masing dan dapat dikombinasikan untuk membentuk arsitektur program yang lebih efisien.

---

## 🧠 Kesimpulan

Melalui praktikum ini, saya memahami perbedaan antara paradigma prosedural, OOP, dan fungsional dalam Java. Paradigma prosedural sederhana namun kurang fleksibel untuk program besar, OOP membuat kode lebih terstruktur dan mudah dikembangkan, sedangkan paradigma fungsional lebih ringkas dan efisien dengan penggunaan lambda expression. Secara keseluruhan, tiap paradigma memiliki keunggulan tersendiri sesuai kebutuhan pengembangan program.

---

## 🎯 Quiz

1. **Apakah OOP selalu lebih baik dari prosedural?**
   **Jawaban:** Tidak selalu. Paradigma OOP memang lebih unggul dalam hal pengelolaan program yang besar dan kompleks karena dapat memisahkan kode menjadi bagian-bagian kecil yang mudah dikelola. Namun, untuk program sederhana atau tugas yang hanya membutuhkan beberapa baris kode, paradigma prosedural bisa lebih efisien karena tidak memerlukan struktur kelas dan objek yang rumit.

2. **Kapan functional programming lebih cocok digunakan dibanding OOP atau prosedural?** 
   **Jawaban:** Paradigma fungsional lebih cocok digunakan ketika program berfokus pada pengolahan data, seperti perhitungan matematis, pemrosesan data dalam jumlah besar, atau analisis yang membutuhkan operasi berulang terhadap data. Dengan pendekatan fungsional, kode menjadi lebih ringkas, mudah diuji, dan minim kesalahan karena tidak bergantung pada perubahan variabel atau kondisi tertentu.

3. **[Bagaimana paradigma (prosedural, OOP, fungsional) memengaruhi maintainability dan scalability aplikasi?**
   **Jawaban:** Setiap paradigma memiliki pengaruh berbeda terhadap kemudahan pemeliharaan (maintainability) dan pengembangan (scalability) aplikasi.
   - Paradigma prosedural cenderung sulit dipelihara jika program bertambah besar karena logika program sering bercampur dalam satu alur.
   - Paradigma OOP lebih mudah dikembangkan karena kode tersusun dalam kelas dan objek yang bisa digunakan kembali.
   - Paradigma fungsional meningkatkan keandalan program karena fungsi bersifat independen dan tidak mengubah data di luar fungsinya, sehingga lebih mudah diuji dan dikembangkan secara paralel.

4. **Mengapa OOP lebih cocok untuk mengembangkan aplikasi POS dibanding prosedural?]**
   **Jawaban:** Aplikasi POS (Point of Sale) melibatkan banyak entitas seperti produk, pelanggan, dan transaksi yang saling berhubungan. Dengan menggunakan OOP, setiap entitas dapat dibuat sebagai objek dengan atribut dan perilakunya sendiri. Hal ini membuat struktur program lebih terorganisir, mudah diperluas, dan lebih efisien ketika aplikasi terus berkembang atau mengalami perubahan fitur.
   
5. **Bagaimana paradigma fungsional dapat membantu mengurangi kode berulang (boilerplate code)?**
   **Jawaban:** Paradigma fungsional memungkinkan penulisan kode yang lebih ringkas melalui penggunaan lambda expression, stream API, dan fungsi-fungsi bawaan Java. Dengan cara ini, programmer tidak perlu membuat banyak loop atau method tambahan untuk operasi yang sama. Akibatnya, kode menjadi lebih pendek, mudah dibaca, dan lebih sedikit risiko kesalahan berulang.
