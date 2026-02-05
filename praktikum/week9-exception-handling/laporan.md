# Laporan Praktikum Minggu 9  
Topik: Exception Handling, Custom Exception, dan Design Pattern

## Identitas
- Nama  : Ahmad Rafie Ramadhani Azzaki 
- NIM   : 240202849
- Kelas : 3IKRA

---

## Tujuan

Mahasiswa mampu memahami perbedaan error dan exception, mengimplementasikan try–catch–finally, membuat custom exception, serta menerapkan exception handling pada sistem keranjang belanja Agri-POS.

---

## Dasar Teori

1. Error merupakan kesalahan fatal yang tidak dapat ditangani program.
2. Exception merupakan kesalahan yang dapat ditangani oleh program.
3. Struktur try–catch–finally digunakan untuk menangani error saat runtime.
4. Custom exception dibuat untuk menangani kesalahan khusus dalam aplikasi.
5. Design pattern membantu membuat program lebih terstruktur.

---

## Langkah Praktikum

1. Mempelajari konsep error dan exception.
2. Membuat class custom exception.
3. Membuat class Product dengan atribut stok.
4. Mengimplementasikan ShoppingCart dengan exception handling.
5. Membuat program utama untuk pengujian.
6. Menerapkan Singleton dan konsep MVC sederhana.
7. Menjalankan program dan mengambil screenshot hasil.
8. Melakukan commit dengan pesan:  
   `week9-exception: implementasi custom exception`.

---

## Kode Program

### Custom Exception: InvalidQuantityException

```java
package com.upb.agripos;

public class InvalidQuantityException extends Exception {

    public InvalidQuantityException(String msg) {
        super(msg);
    }
}
```

### Custom Exception: ProductNotFoundException
```java
package com.upb.agripos;

public class ProductNotFoundException extends Exception {

    public ProductNotFoundException(String msg) {
        super(msg);
    }
}
```

### Custom Exception: InsufficientStockException
```java
package com.upb.agripos;

public class InsufficientStockException extends Exception {

    public InsufficientStockException(String msg) {
        super(msg);
    }
}
```

### Class Product
```java
package com.upb.agripos;

public class Product {

    private final String code;
    private final String name;
    private final double price;
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

    public void reduceStock(int qty) {
        this.stock -= qty;
    }
}
```

### Class ShoppingCart
```java
package com.upb.agripos;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private final Map<Product, Integer> items =
            new HashMap<>();

    public void addProduct(Product p, int qty)
            throws InvalidQuantityException {

        if (qty <= 0) {
            throw new InvalidQuantityException(
                "Quantity harus lebih dari 0."
            );
        }

        items.put(p,
            items.getOrDefault(p, 0) + qty);
    }

    public void removeProduct(Product p)
            throws ProductNotFoundException {

        if (!items.containsKey(p)) {
            throw new ProductNotFoundException(
                "Produk tidak ada dalam keranjang."
            );
        }

        items.remove(p);
    }

    public void checkout()
            throws InsufficientStockException {

        for (Map.Entry<Product, Integer> e
                : items.entrySet()) {

            Product product = e.getKey();
            int qty = e.getValue();

            if (product.getStock() < qty) {
                throw new InsufficientStockException(
                    "Stok tidak cukup untuk: "
                    + product.getName()
                );
            }
        }

        for (Map.Entry<Product, Integer> e
                : items.entrySet()) {

            e.getKey().reduceStock(e.getValue());
        }
    }
}
```

### Product Service
```java
package com.upb.agripos;

public class ProductService {

    private static ProductService instance;

    private ProductService() {}

    public static ProductService getInstance() {

        if (instance == null) {
            instance = new ProductService();
        }

        return instance;
    }
}
```

### MainExceptionDemo
```java
package com.upb.agripos;

public class MainExceptionDemo {

    public static void main(String[] args) {

        System.out.println(
            "Hello, I am [Nama]-[NIM] (Week9)"
        );

        ShoppingCart cart = new ShoppingCart();

        Product p1 = new Product(
            "P01", "Pupuk Organik", 25000, 3
        );

        try {
            cart.addProduct(p1, -1);
        } catch (InvalidQuantityException e) {
            System.out.println(
                "Kesalahan: " + e.getMessage()
            );
        }

        try {
            cart.removeProduct(p1);
        } catch (ProductNotFoundException e) {
            System.out.println(
                "Kesalahan: " + e.getMessage()
            );
        }

        try {
            cart.addProduct(p1, 5);
            cart.checkout();
        } catch (Exception e) {
            System.out.println(
                "Kesalahan: " + e.getMessage()
            );
        }
    }
}
```

## Hasil Screenshots
