# Laporan Praktikum Minggu 11  
Topik: Data Access Object (DAO) dan CRUD Database dengan JDBC

## Identitas
- Nama  : Ahmad Rafie Ramadhani Azzaki
- NIM   : 240202849
- Kelas : 3IKRA

---

## Tujuan

Mahasiswa mampu memahami konsep Data Access Object (DAO), menghubungkan aplikasi Java dengan database PostgreSQL menggunakan JDBC, serta mengimplementasikan operasi CRUD secara lengkap.

---

## Dasar Teori

1. DAO memisahkan logika bisnis dan logika akses database.
2. JDBC digunakan untuk menghubungkan Java dengan database relasional.
3. PreparedStatement digunakan untuk mencegah SQL Injection.
4. CRUD terdiri dari Create, Read, Update, dan Delete.
5. DAO mendukung struktur kode yang rapi dan mudah dikembangkan.

---

## Langkah Praktikum

1. Membuat database `agripos` pada PostgreSQL.
2. Membuat tabel `products` menggunakan file SQL.
3. Membuat class model `Product`.
4. Membuat interface `ProductDAO`.
5. Mengimplementasikan `ProductDAOImpl` dengan JDBC.
6. Membuat class `MainDAOTest` untuk pengujian.
7. Menjalankan operasi CRUD.
8. Mengambil screenshot hasil program.
9. Melakukan commit dengan pesan:  
   `week11-dao-database: implementasi crud jdbc`.

---

## Kode Program

### Class Product

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

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
```

### Interface ProductDAO
```java
package com.upb.agripos.dao;

import java.util.List;
import com.upb.agripos.model.Product;

public interface ProductDAO {

    void insert(Product product) throws Exception;

    Product findByCode(String code) throws Exception;

    List<Product> findAll() throws Exception;

    void update(Product product) throws Exception;

    void delete(String code) throws Exception;
}
```

### Implementasi ProductDAOImpl
```java
package com.upb.agripos.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.upb.agripos.model.Product;

public class ProductDAOImpl implements ProductDAO {

    private final Connection connection;

    public ProductDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Product p) throws Exception {

        String sql =
            "INSERT INTO products(code, name, price, stock) " +
            "VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps =
                connection.prepareStatement(sql)) {

            ps.setString(1, p.getCode());
            ps.setString(2, p.getName());
            ps.setDouble(3, p.getPrice());
            ps.setInt(4, p.getStock());

            ps.executeUpdate();
        }
    }

    @Override
    public Product findByCode(String code)
            throws Exception {

        String sql =
            "SELECT * FROM products WHERE code = ?";

        try (PreparedStatement ps =
                connection.prepareStatement(sql)) {

            ps.setString(1, code);

            try (ResultSet rs =
                    ps.executeQuery()) {

                if (rs.next()) {

                    return new Product(
                        rs.getString("code"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("stock")
                    );
                }
            }
        }

        return null;
    }

    @Override
    public List<Product> findAll()
            throws Exception {

        List<Product> list =
            new ArrayList<>();

        String sql = "SELECT * FROM products";

        try (PreparedStatement ps =
                connection.prepareStatement(sql);
             ResultSet rs =
                ps.executeQuery()) {

            while (rs.next()) {

                list.add(new Product(
                    rs.getString("code"),
                    rs.getString("name"),
                    rs.getDouble("price"),
                    rs.getInt("stock")
                ));
            }
        }

        return list;
    }

    @Override
    public void update(Product p)
            throws Exception {

        String sql =
            "UPDATE products " +
            "SET name=?, price=?, stock=? " +
            "WHERE code=?";

        try (PreparedStatement ps =
                connection.prepareStatement(sql)) {

            ps.setString(1, p.getName());
            ps.setDouble(2, p.getPrice());
            ps.setInt(3, p.getStock());
            ps.setString(4, p.getCode());

            ps.executeUpdate();
        }
    }

    @Override
    public void delete(String code)
            throws Exception {

        String sql =
            "DELETE FROM products WHERE code=?";

        try (PreparedStatement ps =
                connection.prepareStatement(sql)) {

            ps.setString(1, code);

            ps.executeUpdate();
        }
    }
}
```

### Main Program: MainDAOTest
```java
package com.upb.agripos;

import java.sql.Connection;
import java.sql.DriverManager;

import com.upb.agripos.dao.ProductDAO;
import com.upb.agripos.dao.ProductDAOImpl;
import com.upb.agripos.model.Product;

public class MainDAOTest {

    public static void main(String[] args)
            throws Exception {

        Connection conn =
            DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/agripos",
                "postgres",
                "1234"
            );

        ProductDAO dao =
            new ProductDAOImpl(conn);

        dao.insert(
            new Product("P01",
                        "Pupuk Organik",
                        25000, 10)
        );

        dao.update(
            new Product("P01",
                        "Pupuk Organik Premium",
                        30000, 8)
        );

        Product p =
            dao.findByCode("P01");

        System.out.println(p.getName());

        dao.delete("P01");

        conn.close();
    }
}
```

## Hasil Screenshots
<img width="927" height="68" alt="Screenshot 2026-02-05 202423" src="https://github.com/user-attachments/assets/d221c80e-2f47-44a4-b26c-5b8df015e29b" />


## Analisis

- DAO memisahkan akses database dari logika aplikasi.

- PreparedStatement membuat query lebih aman.

- CRUD berjalan dengan baik melalui DAO.

- Integrasi DAO mempermudah pengembangan aplikasi.

- Dibanding minggu sebelumnya, program sudah terhubung dengan database.

- Kendala utama adalah konfigurasi driver PostgreSQL.

## Kesimpulan

Penerapan DAO dan JDBC membuat aplikasi lebih terstruktur dan aman. Operasi CRUD dapat dijalankan secara efisien tanpa mencampur logika bisnis dengan akses database.

## Quiz
1. Jelaskan konsep Data Access Object (DAO).

Jawaban:
DAO adalah pola desain yang memisahkan logika akses data dari logika bisnis sehingga aplikasi lebih terstruktur dan mudah dikembangkan.

2. Mengapa PreparedStatement lebih disarankan dibanding Statement?

Jawaban:
Karena PreparedStatement lebih aman dari SQL Injection dan lebih efisien dalam eksekusi query berulang.

3. Apa keuntungan menggunakan JDBC dalam aplikasi Java?

Jawaban:
JDBC memungkinkan aplikasi Java terhubung dengan berbagai database relasional secara standar.

4. Mengapa DAO tidak boleh dipanggil langsung oleh UI?

Jawaban:
Agar tidak terjadi ketergantungan langsung antara tampilan dan database, sehingga kode lebih fleksibel dan mudah dirawat.
