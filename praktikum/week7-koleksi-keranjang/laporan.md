# Laporan Praktikum Minggu 7  
Topik: Collections dan Implementasi Keranjang Belanja

## Identitas
- Nama  : Ahmad Rafie Ramadhani Azzaki
- NIM   : 240202849
- Kelas : 3IKRA

---

## Tujuan

Mahasiswa mampu memahami konsep Java Collections Framework, menggunakan List dan Map untuk mengelola data, serta mengimplementasikan keranjang belanja sederhana pada sistem Agri-POS.

---

## Dasar Teori

1. Java Collections Framework menyediakan struktur data dinamis.
2. List (ArrayList) menyimpan data secara berurutan dan dapat duplikat.
3. Map (HashMap) menyimpan data dalam bentuk key–value.
4. Set (HashSet) tidak mengizinkan data duplikat.
5. Collections mempermudah pengelolaan data dalam aplikasi.

---

## Langkah Praktikum

1. Mempelajari materi tentang List, Map, dan Set.
2. Membuat class `Product`.
3. Membuat class `ShoppingCart` menggunakan ArrayList.
4. Membuat class `ShoppingCartMap` menggunakan HashMap.
5. Membuat class `MainCart` sebagai program utama.
6. Menjalankan program dan mengambil screenshot hasil eksekusi.
7. Menyimpan file pada folder week7-collections.
8. Melakukan commit dengan pesan:  
   `week7-collections: implementasi shopping cart`.

---

## Kode Program

### Class Product

```java
package com.upb.agripos;

public class Product {

    private final String code;
    private final String name;
    private final double price;

    public Product(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
```

### Class ShoppingCart (ArrayList)
```java
package com.upb.agripos;

import java.util.ArrayList;

public class ShoppingCart {

    private final ArrayList<Product> items = new ArrayList<>();

    public void addProduct(Product p) {
        items.add(p);
    }

    public void removeProduct(Product p) {
        items.remove(p);
    }

    public double getTotal() {
        double sum = 0;
        for (Product p : items) {
            sum += p.getPrice();
        }
        return sum;
    }

    public void printCart() {
        System.out.println("Isi Keranjang:");
        for (Product p : items) {
            System.out.println("- " + p.getCode() + " " +
                               p.getName() + " = " +
                               p.getPrice());
        }
        System.out.println("Total: " + getTotal());
    }
}
```

### Class ShoppingCartMap (HashMap)
```java
package com.upb.agripos;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCartMap {

    private final Map<Product, Integer> items = new HashMap<>();

    public void addProduct(Product p) {
        items.put(p, items.getOrDefault(p, 0) + 1);
    }

    public void removeProduct(Product p) {
        if (!items.containsKey(p)) return;

        int qty = items.get(p);

        if (qty > 1) {
            items.put(p, qty - 1);
        } else {
            items.remove(p);
        }
    }

    public double getTotal() {
        double total = 0;

        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }

        return total;
    }

    public void printCart() {
        System.out.println("Isi Keranjang (Map):");

        for (Map.Entry<Product, Integer> e : items.entrySet()) {
            System.out.println("- " + e.getKey().getCode() +
                               " " + e.getKey().getName() +
                               " x" + e.getValue());
        }

        System.out.println("Total: " + getTotal());
    }
}
  ```

### Class MainCart
```java
package com.upb.agripos;

public class MainCart {

    public static void main(String[] args) {

        System.out.println("Hello, I am [Nama]-[NIM] (Week7)");

        Product p1 = new Product("P01", "Beras", 50000);
        Product p2 = new Product("P02", "Pupuk", 30000);

        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.printCart();

        cart.removeProduct(p1);
        cart.printCart();
    }
}
```

## Hasil Screenshots

<img width="1078" height="423" alt="Screenshot 2026-02-05 182114" src="https://github.com/user-attachments/assets/cb803d25-7926-4f20-8776-8899eca6c42c" />

## Analisis

- Program menggunakan ArrayList untuk menyimpan data produk.

- Setiap produk dapat ditambahkan dan dihapus dengan mudah.

- HashMap digunakan untuk menyimpan produk beserta jumlahnya.

- Dibanding minggu sebelumnya, program lebih fokus pada pengelolaan data.

- Kendala utama adalah memahami perbedaan penggunaan List dan Map.

- Kendala diatasi dengan mempelajari dokumentasi Java Collections.

## Kesimpulan
Penggunaan Java Collections Framework mempermudah pengelolaan data dalam sistem Agri-POS. ArrayList cocok untuk keranjang sederhana, sedangkan HashMap lebih efektif untuk menangani jumlah produk.

## Quiz
1. Jelaskan perbedaan mendasar antara List, Map, dan Set.

Jawaban:
List menyimpan data secara berurutan dan boleh duplikat.
Map menyimpan data dalam bentuk key–value.
Set menyimpan data unik tanpa duplikasi.

2. Mengapa ArrayList cocok digunakan untuk keranjang belanja sederhana?

Jawaban:
Karena ArrayList mudah digunakan, mendukung penambahan dan penghapusan data, serta cocok untuk jumlah data kecil hingga menengah.

3. Bagaimana struktur Set mencegah duplikasi data?

Jawaban:
Set menggunakan mekanisme hashing untuk memastikan setiap elemen bersifat unik, sehingga data yang sama tidak dapat disimpan lebih dari satu kali.

4. Kapan sebaiknya menggunakan Map dibandingkan List? Jelaskan dengan contoh.

Jawaban:
Map digunakan ketika data memiliki pasangan key–value.

Contoh:
Produk sebagai key dan jumlah sebagai value pada keranjang belanja:

```java
Map<Product, Integer> cart = new HashMap<>();
cart.put(p1, 2);
```
