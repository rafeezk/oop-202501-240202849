package com.upb.agripos.model.pembayaran;

import com.upb.agripos.model.kontrak.Receiptable;

public class Cash extends Pembayaran implements Receiptable {
    private double tunai;

    public Cash(String invoiceNo, double total, double tunai) {
        super(invoiceNo, total);
        this.tunai = tunai;
    }

    public double biaya() {
        return 0;
    }

    public boolean prosesPembayaran() {
        return tunai >= totalBayar();
    }

    public String cetakStruk() {
        return String.format("INVOICE %s | TOTAL: %.2f | CASH: %.2f | KEMBALI: %.2f",
                invoiceNo, totalBayar(), tunai, Math.max(0, tunai - totalBayar()));
    }
}
