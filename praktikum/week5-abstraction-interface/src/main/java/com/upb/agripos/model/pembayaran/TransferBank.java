package com.upb.agripos.model.pembayaran;

import com.upb.agripos.model.kontrak.Validatable;
import com.upb.agripos.model.kontrak.Receiptable;

public class TransferBank extends Pembayaran implements Validatable, Receiptable {
    private String bank;
    private String kodeVerifikasi;

    public TransferBank(String invoiceNo, double total, String bank, String kodeVerifikasi) {
        super(invoiceNo, total);
        this.bank = bank;
        this.kodeVerifikasi = kodeVerifikasi;
    }

    public double biaya() {
        return 3500;
    }

    public boolean validasi() {
        return "VALID".equals(kodeVerifikasi);
    }

    public boolean prosesPembayaran() {
        return validasi();
    }

    public String cetakStruk() {
        return String.format("INVOICE %s | TOTAL+FEE: %.2f | BANK: %s | STATUS: %s",
                invoiceNo, totalBayar(), bank, prosesPembayaran() ? "BERHASIL" : "GAGAL");
    }
}
