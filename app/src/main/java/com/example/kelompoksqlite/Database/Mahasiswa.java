package com.example.kelompoksqlite.Database;

import android.os.Parcel;
import android.os.Parcelable;

public class Mahasiswa implements Parcelable {
    private int idMahasiswa = 0;
    private String nama = " EMPTY ";
    private String tglLahir = " EMPTY ";
    private String jenKel = " EMPTY ";
    private String alamat = " EMPTY ";
    public static final Parcelable.Creator<Mahasiswa> CREATOR = new Parcelable.Creator<Mahasiswa>(){
        public Mahasiswa createFromParcel(Parcel in) {
            return new Mahasiswa(in);
        }

        @Override
        public Mahasiswa[] newArray(int i) {
            return new Mahasiswa[i];
        }
    };

    public Mahasiswa(Parcel in) {
        idMahasiswa = in.readInt();
        nama = in.readString();
        tglLahir = in.readString();
        jenKel = in.readString();
        alamat = in.readString();
    }

    public Mahasiswa(int idMahasiswa, String nama, String tglLahir, String jenKel, String alamat) {
        this.idMahasiswa = idMahasiswa;
        this.nama = nama;
        this.tglLahir = tglLahir;
        this.jenKel = jenKel;
        this.alamat = alamat;
    }

    public static Mahasiswa getPosition() {
        return getPosition();
    }


    public int getIdMahasiswa() {
        return idMahasiswa;
    }

    public void setIdMahasiswa(int idMahasiswa) {
        this.idMahasiswa = idMahasiswa;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(String tglLahir) {
        this.tglLahir = tglLahir;
    }

    public String getJenKel() {
        return jenKel;
    }

    public void setJenKel(String jenKel) {
        this.jenKel = jenKel;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public static Creator<Mahasiswa> getCREATOR() {
        return CREATOR;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(idMahasiswa);
        parcel.writeString(nama);
        parcel.writeString(tglLahir);
        parcel.writeString(jenKel);
        parcel.writeString(alamat);

    }
}

