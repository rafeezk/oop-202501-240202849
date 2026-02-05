# Laporan Praktikum Minggu 5  
Topik: Abstraction (Abstract Class & Interface)

## Identitas
- Nama  : Ahmad Rafie Ramadhani Azzaki  
- NIM   : 240202849
- Kelas : 3IKRA

---

## Tujuan
Mahasiswa mampu memahami konsep abstraksi dalam OOP, membedakan penggunaan abstract class dan interface, serta mengimplementasikan multiple inheritance menggunakan interface dalam program Java.

---

## Dasar Teori

1. Abstraksi adalah proses menyederhanakan sistem dengan menyembunyikan detail implementasi.
2. Abstract class digunakan sebagai class induk dan dapat memiliki method abstrak maupun non-abstrak.
3. Interface berfungsi sebagai kontrak yang harus diimplementasikan oleh class.
4. Java mendukung multiple inheritance melalui interface.
5. Polimorfisme memungkinkan objek diperlakukan sebagai tipe induknya.

---

## Langkah Praktikum

1. Mempelajari materi tentang abstract class dan interface.
2. Membuat abstract class `Pembayaran`.
3. Membuat interface `Validatable` dan `Receiptable`.
4. Mengimplementasikan class `Cash`, `EWallet`, dan `TransferBank`.
5. Membuat class `MainAbstraction` untuk menjalankan program.
6. Menjalankan program dan mengambil screenshot hasil eksekusi.
7. Melakukan commit dan push dengan pesan: `week5-abstraction-interface`.

---

## Kode Program

### Abstract Class Pembayaran

```java
public abstract class Pembayaran {

    protected String invoiceNo;
    protected double total;

    public Pembayaran(String invoiceNo, double total) {
        this.invoiceNo = invoiceNo;
        this.total = total;
    }

    public abstract double biaya();
    public abstract boolean prosesPembayaran();

    public double totalBayar() {
        return total + biaya();
    }
}
```

### Interface Validatable
```java
public interface Validatable {
    boolean validasi();
}
```

### Interface Receiptable
```java
public interface Receiptable {
    String cetakStruk();
}
```

### Class Cash
```java
public class Cash extends Pembayaran implements Receiptable {

    private double tunai;

    public Cash(String invoiceNo, double total, double tunai) {
        super(invoiceNo, total);
        this.tunai = tunai;
    }

    @Override
    public double biaya() {
        return 0;
    }

    @Override
    public boolean prosesPembayaran() {
        return tunai >= totalBayar();
    }

    @Override
    public String cetakStruk() {
        return "Invoice: " + invoiceNo +
               " Total: " + totalBayar() +
               " Tunai: " + tunai;
    }
}
```

### Class EWallet
```java
public class EWallet extends Pembayaran
        implements Validatable, Receiptable {

    private String akun;
    private String otp;

    public EWallet(String invoiceNo, double total,
                   String akun, String otp) {
        super(invoiceNo, total);
        this.akun = akun;
        this.otp = otp;
    }

    @Override
    public double biaya() {
        return total * 0.015;
    }

    @Override
    public boolean validasi() {
        return otp != null && otp.length() == 6;
    }

    @Override
    public boolean prosesPembayaran() {
        return validasi();
    }

    @Override
    public String cetakStruk() {
        return "Invoice: " + invoiceNo +
               " Total: " + totalBayar() +
               " Akun: " + akun;
    }
}
```

### Class TransferBank
```java
public class TransferBank extends Pembayaran
        implements Validatable, Receiptable {

    private String noRek;
    private String kode;

    public TransferBank(String invoiceNo, double total,
                        String noRek, String kode) {
        super(invoiceNo, total);
        this.noRek = noRek;
        this.kode = kode;
    }
```
### Main Abstraction
```java
    @Override
    public double biaya() {
        return 3500;
    }

    @Override
    public boolean validasi() {
        return kode != null && kode.length() == 4;
    }

    @Overridepublic class MainAbstraction {

    public static void main(String[] args) {

        Pembayaran cash =
            new Cash("INV01", 100000, 120000);

        Pembayaran ew =
            new EWallet("INV02", 150000,
                        "user@mail", "123456");

        Pembayaran tf =
            new TransferBank("INV03", 200000,
                             "123456789", "4321");

        System.out.println(((Receiptable) cash).cetakStruk());
        System.out.println(((Receiptable) ew).cetakStruk());
        System.out.println(((Receiptable) tf).cetakStruk());
    }
}
```

## Hasil Screenshots
<img width="1077" height="228" alt="Screenshot 2026-02-05 174639" src="https://github.com/user-attachments/assets/ed674573-03b3-4513-a48a-8a57105e733b" />

## Analisis

- Program menggunakan abstract class sebagai induk.

- Class turunan mengimplementasikan method abstrak.

- Interface digunakan untuk fitur validasi dan cetak struk.

- Dibanding minggu sebelumnya, program ini lebih fleksibel karena menggunakan abstraksi.

- Kendala yang dihadapi adalah memahami hubungan abstract class dan interface.

- Kendala diatasi dengan mempelajari contoh program dan dokumentasi Java.

## Kesimpulan
Dengan menggunakan abstract class dan interface, program menjadi lebih terstruktur, fleksibel, serta mudah dikembangkan. Multiple inheritance dapat diterapkan tanpa konflik melalui interface.

## Quiz

1. Jelaskan perbedaan konsep dan penggunaan abstract class dan interface.
Jawaban:
Abstract class dapat memiliki atribut dan method dengan atau tanpa implementasi, sedangkan interface hanya berisi kontrak method. Abstract class digunakan sebagai dasar pewarisan, sedangkan interface digunakan untuk menambah kemampuan class.

2. Mengapa multiple inheritance lebih aman dilakukan dengan interface pada Java?
Jawaban:
Karena interface tidak memiliki implementasi utama sehingga tidak menimbulkan konflik method dan menghindari diamond problem.

3. Pada contoh Agri-POS, bagian mana yang paling tepat menjadi abstract class dan mana yang menjadi interface? Jelaskan alasannya.
Jawaban:
Pembayaran menjadi abstract class karena memiliki atribut dan perilaku umum. Validatable dan Receiptable menjadi interface karena hanya sebagai kontrak validasi dan cetak struk.
