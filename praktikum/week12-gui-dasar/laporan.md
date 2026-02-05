# Laporan Praktikum Minggu 12  
Topik: GUI Dasar JavaFX (Event-Driven Programming)

## Identitas
- Nama  : Ahmad Rafie Ramadhani Azzaki
- NIM   : 240202849
- Kelas : 3IKRA

---

## Tujuan

Mahasiswa mampu memahami konsep event-driven programming, membangun antarmuka grafis menggunakan JavaFX, membuat form input produk, serta mengintegrasikan GUI dengan modul backend berbasis DAO dan Service.

---

## Dasar Teori

1. Event-driven programming adalah paradigma pemrograman yang merespon aksi pengguna.
2. JavaFX digunakan untuk membuat antarmuka grafis berbasis Java.
3. GUI memisahkan tampilan dan logika menggunakan pendekatan MVC.
4. DAO dan Service digunakan sebagai penghubung GUI dengan database.
5. Prinsip DIP diterapkan agar View tidak bergantung langsung pada DAO.

---

## Langkah Praktikum

1. Menggunakan hasil praktikum Week 7, 10, dan 11 sebagai backend.
2. Membuat struktur project JavaFX.
3. Membuat form input produk menggunakan TextField dan Button.
4. Membuat ProductService sebagai penghubung DAO.
5. Membuat ProductController untuk mengelola event.
6. Mengatur event handler tombol "Tambah Produk".
7. Menampilkan data produk pada ListView.
8. Menjalankan program dan mengambil screenshot GUI.
9. Melakukan commit dengan pesan:  
   `week12-gui-dasar: implementasi form produk`.

---

## Kode Program

### Model: Product

```java
package com.upb.agripos.model;

public class Product {

    private String code;
    private String name;
    private double price;
    private int stock;

    public Product(String code, String name,
                   double price, int stock) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }
}
```

### DAO: ProductDAO
```java
package com.upb.agripos.dao;

import java.util.List;
import com.upb.agripos.model.Product;

public interface ProductDAO {

    void insert(Product product) throws Exception;

    List<Product> findAll() throws Exception;
}
```

### Service: ProductService
```java
package com.upb.agripos.service;

import java.util.List;

import com.upb.agripos.dao.ProductDAO;
import com.upb.agripos.model.Product;

public class ProductService {

    private final ProductDAO dao;

    public ProductService(ProductDAO dao) {
        this.dao = dao;
    }

    public void insert(Product p) throws Exception {
        dao.insert(p);
    }

    public List<Product> getAll() throws Exception {
        return dao.findAll();
    }
}
```

### Controller: ProductController
```java
package com.upb.agripos.controller;

import com.upb.agripos.model.Product;
import com.upb.agripos.service.ProductService;

public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    public void addProduct(Product p) throws Exception {
        service.insert(p);
    }
}
```

### View: ProductFormView (JavaFX)
```java
package com.upb.agripos.view;

import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class ProductFormView extends VBox {

    public TextField txtCode = new TextField();
    public TextField txtName = new TextField();
    public TextField txtPrice = new TextField();
    public TextField txtStock = new TextField();

    public Button btnAdd = new Button("Tambah Produk");

    public ListView<String> listView =
        new ListView<>();

    public ProductFormView() {

        txtCode.setPromptText("Kode Produk");
        txtName.setPromptText("Nama Produk");
        txtPrice.setPromptText("Harga");
        txtStock.setPromptText("Stok");

        getChildren().addAll(
            txtCode, txtName,
            txtPrice, txtStock,
            btnAdd, listView
        );
    }
}
```

### Main Program: AppJavaFX
```java
package com.upb.agripos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.upb.agripos.controller.ProductController;
import com.upb.agripos.dao.ProductDAOImpl;
import com.upb.agripos.model.Product;
import com.upb.agripos.service.ProductService;
import com.upb.agripos.view.ProductFormView;

public class AppJavaFX extends Application {

    @Override
    public void start(Stage stage) {

        ProductDAOImpl dao =
            new ProductDAOImpl();

        ProductService service =
            new ProductService(dao);

        ProductController controller =
            new ProductController(service);

        ProductFormView view =
            new ProductFormView();

        view.btnAdd.setOnAction(event -> {

            try {

                Product p = new Product(
                    view.txtCode.getText(),
                    view.txtName.getText(),
                    Double.parseDouble(
                        view.txtPrice.getText()),
                    Integer.parseInt(
                        view.txtStock.getText())
                );

                controller.addProduct(p);

                view.listView.getItems().add(
                    p.getCode() + " - " + p.getName()
                );

            } catch (Exception e) {
                System.out.println(
                    "Error: " + e.getMessage()
                );
            }
        });

        Scene scene =
            new Scene(view, 400, 450);

        stage.setTitle("Agri-POS Produk");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
```
### Hasil Screenshots
<img width="1920" height="1080" alt="Screenshot (540)" src="https://github.com/user-attachments/assets/b2401cb8-69be-49ac-9332-b87b6482f378" />


## Analisis
- Program menggunakan event handler JavaFX.

- View hanya menangani tampilan.

- Controller mengelola logika.

- Service menghubungkan ke DAO.

- GUI tidak memanggil database secara langsung.

- Struktur mengikuti MVC dan prinsip DIP.

- Kendala utama adalah sinkronisasi UI dengan backend.

## Tabel Traceability Bab 6 → GUI
Artefak Bab 6	Referensi	Handler GUI	Controller / Service	DAO	Dampak UI / DB
Use Case	UC-01 Tambah Produk	Tombol Tambah	ProductController.add() → ProductService.insert()	ProductDAO.insert()	Data tampil + tersimpan DB
Activity	AD-01 Tambah Produk	Tombol Tambah	addProduct()	insert()	Validasi → Simpan → Tampil
Sequence	SD-01 Tambah Produk	Tombol Tambah	View → Controller → Service	DAO → DB	Urutan sesuai desain
Kesimpulan
Penerapan JavaFX dengan pendekatan MVC dan DAO membuat aplikasi lebih terstruktur. GUI dapat berinteraksi dengan database secara aman melalui service tanpa melanggar prinsip desain.

## Refleksi
Keunggulan sistem:

- Modular

- Mudah dikembangkan

- Konsisten dengan Bab 6

- Potensi pengembangan:

Menggunakan TableView

Fitur edit dan hapus produk

Validasi input lebih lengkap
