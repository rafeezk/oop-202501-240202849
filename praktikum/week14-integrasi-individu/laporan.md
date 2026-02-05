# Laporan Praktikum Minggu 14  
Topik: Integrasi Individu (OOP + Database + GUI)

## Identitas
- Nama  : Ahmad Rafie Ramadhani Azzaki  
- NIM   : 240202849
- Kelas : 3IKRA

---

## Tujuan

Mahasiswa mampu mengintegrasikan seluruh konsep OOP, UML, SOLID, Collections, Exception Handling, Design Pattern, Database, dan GUI JavaFX ke dalam satu aplikasi Agri-POS yang utuh.

---

## Ringkasan Aplikasi

Aplikasi Agri-POS merupakan sistem kasir sederhana berbasis JavaFX yang memiliki fitur:

- Manajemen Produk (CRUD via PostgreSQL).
- Tampilan produk menggunakan TableView.
- Keranjang belanja berbasis Collections.
- Perhitungan total belanja.
- Validasi input menggunakan custom exception.
- Penerapan Singleton dan MVC.
- Unit testing pada CartService.

Aplikasi terhubung penuh dengan database dan backend.

---

## Integrasi Bab 1–13

| Bab | Materi                          | Implementasi pada Bab 14                    |
|-----|---------------------------------|---------------------------------------------|
| 1–5 | OOP & Abstraksi                 | Struktur class Model, Service, Controller   |
| 6   | UML & SOLID                     | Arsitektur MVC + DAO + Service              |
| 7   | Collections                     | Keranjang belanja (Cart, CartItem)          |
| 9   | Exception Handling              | Validasi input produk & keranjang           |
| 10  | Pattern & Unit Testing          | Singleton DB, JUnit CartServiceTest         |
| 11  | DAO + JDBC                      | JdbcProductDAO CRUD PostgreSQL              |
| 12  | GUI JavaFX Dasar                | Form input produk                           |
| 13  | GUI Lanjutan (TableView)        | TableView produk + delete                  |

---

## Artefak UML (Bab 6)

Desain UML yang digunakan dan diperbarui:

- Use Case Diagram: Kelola Produk dan Keranjang
- Activity Diagram: Tambah Produk, Add to Cart
- Sequence Diagram: Tambah dan Hapus Produk
- Class Diagram: MVC + Service + DAO + Cart

Diagram disimpan pada folder `docs/uml/`.

---

## Struktur Arsitektur Aplikasi

Aplikasi menggunakan pendekatan berlapis:

View → Controller → Service → DAO → Database


- View: JavaFX UI
- Controller: PosController
- Service: ProductService, CartService
- DAO: JdbcProductDAO
- Model: Product, Cart, CartItem

Struktur ini menerapkan prinsip DIP.

---

## Kode Program (Contoh Inti)

### Model: CartItem

```java
package com.upb.agripos.model;

public class CartItem {

    private Product product;
    private int quantity;

    public CartItem(Product product, int qty) {
        this.product = product;
        this.quantity = qty;
    }

    public double getSubtotal() {
        return product.getPrice() * quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
```

### Service: CartService
```java
package com.upb.agripos.service;

import java.util.ArrayList;
import java.util.List;

import com.upb.agripos.model.CartItem;
import com.upb.agripos.model.Product;

public class CartService {

    private final List<CartItem> items =
        new ArrayList<>();

    public void addItem(Product p, int qty) {
        items.add(new CartItem(p, qty));
    }

    public double getTotal() {

        double total = 0;

        for (CartItem i : items) {
            total += i.getSubtotal();
        }

        return total;
    }

    public List<CartItem> getItems() {
        return items;
    }
}
```

### Controller: PosController
```java
package com.upb.agripos.controller;

import com.upb.agripos.model.Product;
import com.upb.agripos.service.CartService;
import com.upb.agripos.service.ProductService;

public class PosController {

    private final ProductService productService;
    private final CartService cartService;

    public PosController(ProductService ps,
                         CartService cs) {
        this.productService = ps;
        this.cartService = cs;
    }

    public void addProduct(Product p)
            throws Exception {
        productService.insert(p);
    }

    public void deleteProduct(String code)
            throws Exception {
        productService.delete(code);
    }

    public void addToCart(Product p, int qty) {
        cartService.addItem(p, qty);
    }

    public double getCartTotal() {
        return cartService.getTotal();
    }
}
```

## Hasil Screenshots
<img width="1920" height="1080" alt="Screenshot (542)" src="https://github.com/user-attachments/assets/a25a0077-9866-4ad3-a85f-59931cef2423" />

## Tabel Traceability Bab 6 → Implementasi
Artefak	Referensi	Handler / Trigger	Controller / Service	DAO	Dampak
Use Case	UC-Produk-01 Tambah	Tombol Tambah	PosController.addProduct() → ProductService.insert()	ProductDAO.insert()	DB insert + reload TableView
Sequence	SD-Produk-02 Hapus	Tombol Hapus	PosController.deleteProduct() → ProductService.delete()	ProductDAO.delete()	DB delete + reload TableView
Activity	AD-Cart-01 Tambah Keranjang	Tombol Add to Cart	PosController.addToCart() → CartService.addItem()	-	Total keranjang berubah
Kendala dan Solusi
1. Kendala Integrasi JavaFX dan Database
Kendala: Error koneksi JDBC.

Solusi: Mengatur driver dan koneksi database dengan benar.

2. Kendala Sinkronisasi UI dan Backend
Kendala: Data tidak langsung ter-update.

Solusi: Menggunakan metode reload data setelah operasi CRUD.

## Kesimpulan
Aplikasi Agri-POS berhasil mengintegrasikan seluruh materi Bab 1–13. Sistem berjalan end-to-end mulai dari GUI, backend, hingga database. Arsitektur yang digunakan mendukung pengembangan lanjutan.

## Refleksi
Keunggulan sistem:

- Modular dan scalable

- Mudah dipelihara

- Konsisten dengan desain UML

- Potensi pengembangan:

- Penyimpanan transaksi

Sistem login

Laporan penjualan

Payment gateway
