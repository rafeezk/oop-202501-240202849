# Laporan Praktikum Minggu 10  
Topik: Design Pattern (Singleton, MVC) dan Unit Testing menggunakan JUnit

## Identitas
- Nama  : Ahmad Rafie Ramadhani Azzaki
- NIM   : 240202849
- Kelas : 3IKRA

---

## Tujuan

Mahasiswa mampu memahami konsep design pattern, mengimplementasikan Singleton dan MVC, membuat unit test menggunakan JUnit, serta menganalisis manfaat testing terhadap kualitas perangkat lunak.

---

## Dasar Teori

1. Design pattern merupakan solusi umum dalam perancangan perangkat lunak.
2. Singleton digunakan untuk membatasi jumlah instance class.
3. MVC memisahkan logika aplikasi menjadi Model, View, dan Controller.
4. Unit testing digunakan untuk menguji fungsi program secara terpisah.
5. JUnit adalah framework untuk melakukan unit testing di Java.

---

## Langkah Praktikum

1. Mempelajari konsep Singleton dan MVC.
2. Membuat class DatabaseConnection menggunakan Singleton.
3. Membuat struktur MVC untuk fitur Product.
4. Mengintegrasikan MVC dalam class AppMVC.
5. Membuat unit test menggunakan JUnit.
6. Menjalankan unit test dan mendokumentasikan hasil.
7. Menyimpan screenshot hasil testing.
8. Melakukan commit dengan pesan:  
   `week10-pattern-testing: implementasi mvc dan junit`.

---

## Kode Program

### Singleton: DatabaseConnection

```java
package com.upb.agripos.config;

public class DatabaseConnection {

    private static DatabaseConnection instance;

    private DatabaseConnection() {}

    public static DatabaseConnection getInstance() {

        if (instance == null) {
            instance = new DatabaseConnection();
        }

        return instance;
    }
}
```

### Model: Product
```java
package com.upb.agripos.model;

public class Product {

    private final String code;
    private final String name;

    public Product(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() { return code; }

    public String getName() { return name; }
}
```

### View: ConsoleView
```java
package com.upb.agripos.view;

public class ConsoleView {

    public void showMessage(String message) {
        System.out.println(message);
    }
}
```

### Controller: ProductController
```java
package com.upb.agripos.controller;

import com.upb.agripos.model.Product;
import com.upb.agripos.view.ConsoleView;

public class ProductController {

    private final Product model;
    private final ConsoleView view;

    public ProductController(Product model,
                             ConsoleView view) {
        this.model = model;
        this.view = view;
    }

    public void showProduct() {
        view.showMessage(
            "Produk: " + model.getCode() +
            " - " + model.getName()
        );
    }
}
```

### Main Program: AppMVC
```java
package com.upb.agripos;

import com.upb.agripos.model.Product;
import com.upb.agripos.view.ConsoleView;
import com.upb.agripos.controller.ProductController;

public class AppMVC {

    public static void main(String[] args) {

        System.out.println(
            "Hello, I am [Nama]-[NIM] (Week10)"
        );

        Product product =
            new Product("P01", "Pupuk Organik");

        ConsoleView view = new ConsoleView();

        ProductController controller =
            new ProductController(product, view);

        controller.showProduct();
    }
}
```

### Unit Test: ProductTest
```java
package com.upb.agripos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.upb.agripos.model.Product;

public class ProductTest {

    @Test
    public void testProductName() {

        Product p =
            new Product("P01", "Benih Jagung");

        assertEquals("Benih Jagung",
                     p.getName());
    }
}
```

## Hasil Screenshots
<img width="933" height="112" alt="Screenshot 2026-02-05 201531" src="https://github.com/user-attachments/assets/bee04e77-d18d-4368-9d59-77a03519c9d0" />


## Analisis

- Singleton memastikan hanya satu instance DatabaseConnection.

- MVC memisahkan logika, tampilan, dan kontrol aplikasi.

- Unit test memastikan fungsi Product berjalan dengan benar.

- Program lebih mudah dipelihara dan diuji.

- Dibanding minggu sebelumnya, program lebih terstruktur.

- Kendala utama adalah konfigurasi JUnit.

## Kesimpulan

Penerapan design pattern dan unit testing meningkatkan kualitas perangkat lunak. Singleton mengontrol akses resource, MVC membuat kode terorganisir, dan JUnit membantu mendeteksi kesalahan sejak awal.

## Quiz
1. Mengapa constructor pada Singleton harus bersifat private?

Jawaban:
Agar object tidak dapat dibuat langsung dari luar class, sehingga hanya dapat dibuat melalui method getInstance().

2. Jelaskan manfaat pemisahan Model, View, dan Controller.

Jawaban:
Pemisahan MVC membuat kode lebih terstruktur, mudah dikembangkan, dan mudah dipelihara.

3. Apa peran unit testing dalam menjaga kualitas perangkat lunak?

Jawaban:
Unit testing memastikan setiap fungsi berjalan sesuai harapan dan membantu menemukan bug lebih awal.

4. Apa risiko jika Singleton tidak diimplementasikan dengan benar?

Jawaban:
Dapat menyebabkan lebih dari satu instance, pemborosan resource, dan inkonsistensi data.
