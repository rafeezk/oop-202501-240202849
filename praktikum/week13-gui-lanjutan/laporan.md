# Laporan Praktikum Minggu 13  
Topik: GUI Lanjutan JavaFX (TableView dan Lambda Expression)

## Identitas
- Nama  : Ahmad Rafie Ramadhani Azzaki
- NIM   : 240202849
- Kelas : 3IKRA

---

## Tujuan

Mahasiswa mampu menampilkan data menggunakan TableView JavaFX, mengintegrasikan data dari database, menggunakan lambda expression untuk event handling, serta membangun GUI Agri-POS yang lebih interaktif.

---

## Dasar Teori

1. TableView digunakan untuk menampilkan data dalam bentuk tabel.
2. ObservableList digunakan untuk menghubungkan data dengan GUI.
3. Lambda expression menyederhanakan penulisan event handler.
4. DAO dan Service menjadi penghubung antara GUI dan database.
5. Prinsip MVC dan DIP menjaga struktur aplikasi tetap terorganisir.

---

## Langkah Praktikum

1. Melanjutkan project dari Week 12.
2. Mengganti ListView menjadi TableView.
3. Menambahkan kolom Kode, Nama, Harga, dan Stok.
4. Menghubungkan TableView dengan data dari database.
5. Membuat metode loadData().
6. Menambahkan tombol Tambah dan Hapus.
7. Menggunakan lambda expression pada event handler.
8. Menguji fitur tambah dan hapus produk.
9. Mengambil screenshot hasil GUI.
10. Melakukan commit dengan pesan:  
    `week13-gui-lanjutan: implementasi tableview dan delete`.

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

    public void delete(String code) throws Exception {
        dao.delete(code);
    }

    public List<Product> findAll() throws Exception {
        return dao.findAll();
    }
}
```

### Controller: ProductController
```java
package com.upb.agripos.controller;

import java.util.List;

import com.upb.agripos.model.Product;
import com.upb.agripos.service.ProductService;

public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    public void add(Product p) throws Exception {
        service.insert(p);
    }

    public void delete(String code) throws Exception {
        service.delete(code);
    }

    public List<Product> load() throws Exception {
        return service.findAll();
    }
}
```

### View: ProductTableView
```java
package com.upb.agripos.view;

import javafx.collections.*;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import com.upb.agripos.model.Product;

public class ProductTableView extends VBox {

    public TableView<Product> table =
        new TableView<>();

    public Button btnAdd =
        new Button("Tambah Produk");

    public Button btnDelete =
        new Button("Hapus Produk");

    public ObservableList<Product> data =
        FXCollections.observableArrayList();

    public ProductTableView() {

        TableColumn<Product, String> colCode =
            new TableColumn<>("Kode");

        colCode.setCellValueFactory(
            c -> new javafx.beans.property
                 .SimpleStringProperty(
                     c.getValue().getCode()
                 )
        );

        TableColumn<Product, String> colName =
            new TableColumn<>("Nama");

        colName.setCellValueFactory(
            c -> new javafx.beans.property
                 .SimpleStringProperty(
                     c.getValue().getName()
                 )
        );

        TableColumn<Product, Number> colPrice =
            new TableColumn<>("Harga");

        colPrice.setCellValueFactory(
            c -> new javafx.beans.property
                 .SimpleDoubleProperty(
                     c.getValue().getPrice()
                 )
        );

        TableColumn<Product, Number> colStock =
            new TableColumn<>("Stok");

        colStock.setCellValueFactory(
            c -> new javafx.beans.property
                 .SimpleIntegerProperty(
                     c.getValue().getStock()
                 )
        );

        table.getColumns().addAll(
            colCode, colName, colPrice, colStock
        );

        table.setItems(data);

        getChildren().addAll(
            table, btnAdd, btnDelete
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
import com.upb.agripos.view.ProductTableView;

public class AppJavaFX extends Application {

    @Override
    public void start(Stage stage) {

        ProductDAOImpl dao =
            new ProductDAOImpl();

        ProductService service =
            new ProductService(dao);

        ProductController controller =
            new ProductController(service);

        ProductTableView view =
            new ProductTableView();

        loadData(controller, view);

        view.btnAdd.setOnAction(e -> {

            try {

                Product p =
                    new Product("P0" +
                        (view.data.size()+1),
                        "Produk Baru",
                        20000, 5);

                controller.add(p);
                loadData(controller, view);

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        });

        view.btnDelete.setOnAction(e -> {

            try {

                Product selected =
                    view.table
                        .getSelectionModel()
                        .getSelectedItem();

                if (selected != null) {

                    controller.delete(
                        selected.getCode()
                    );

                    loadData(controller, view);
                }

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        });

        Scene scene =
            new Scene(view, 600, 450);

        stage.setTitle("Agri-POS TableView");
        stage.setScene(scene);
        stage.show();
    }

    private void loadData(
        ProductController controller,
        ProductTableView view) {

        try {

            view.data.clear();

            view.data.addAll(
                controller.load()
            );

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
```

## Hasil Screenshots
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/32266c02-1073-4da9-a741-8989d8511ad6" />


## Analisis
- TableView menampilkan data secara terstruktur.

- ObservableList menghubungkan data dan GUI.

- Lambda expression menyederhanakan event handler.

- View tidak mengakses database secara langsung.

- Semua operasi dilakukan melalui controller dan service.

- Sistem konsisten dengan desain Bab 6.

## Tabel Traceability Bab 6 → GUI
Artefak Bab 6	Referensi	Handler GUI	Controller / Service	DAO	Dampak UI / DB
Use Case	UC-02 Lihat Produk	loadData()	ProductController.load() → ProductService.findAll()	ProductDAO.findAll()	TableView terisi dari DB
Use Case	UC-03 Hapus Produk	Tombol Hapus	ProductController.delete() → ProductService.delete()	ProductDAO.delete()	Data terhapus + reload UI
Sequence	SD-02 Hapus Produk	Tombol Hapus	View → Controller → Service	DAO → DB	Urutan sesuai desain

## Kesimpulan
Penerapan TableView dan lambda expression membuat GUI lebih interaktif dan terstruktur. Integrasi dengan DAO dan Service memastikan data selalu sinkron dengan database.

## Refleksi
Keunggulan sistem:

- Tampilan data lebih rapi

- Event handling sederhana

- Terintegrasi penuh dengan database

- Potensi pengembangan:

- Edit data produk

- Pencarian dan filter

- Pagination data
