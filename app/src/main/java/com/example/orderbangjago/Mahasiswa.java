package com.example.orderbangjago;

public class Mahasiswa {
    private String _id, _nama, _kelas, _jumlah;
    public Mahasiswa (String id, String nama, String kelas, String jumlah) {
        this._id = id;
        this._nama = nama;
        this._kelas = kelas;
        this._jumlah = jumlah;
    }
    public Mahasiswa() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_nama() {
        return _nama;
    }
    public void set_nama(String _nama) {
        this._nama = _nama;
    }
    public String get_kelas() {
        return _kelas;
    }
    public void set_kelas(String _kelas) {
        this._kelas = _kelas;
    }
    public String get_jumlah() {
        return _jumlah;
    }
    public void set_jumlah(String _jumlah) {
        this._jumlah = _jumlah;
    }
}
