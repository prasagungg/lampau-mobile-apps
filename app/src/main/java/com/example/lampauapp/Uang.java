package com.example.lampauapp; // Ganti dengan package name Anda

public class Uang {
    private String nominal;
    private String deskripsi;
    private int photoResourceId; // ID resource gambar

    public Uang(String nominal, String deskripsi, int photoResourceId) {
        this.nominal = nominal;
        this.deskripsi = deskripsi;
        this.photoResourceId = photoResourceId;
    }

    public String getNominal() {
        return nominal;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public int getPhotoResourceId() {
        return photoResourceId;
    }
}