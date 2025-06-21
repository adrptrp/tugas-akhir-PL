package com.contoh.aplikasi.aplikasipertama.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orang")
public class Orang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nama;
    private int umur;

    // Konstruktor default (wajib untuk JPA)
    public Orang() {
    }

    // Konstruktor dengan parameter
    public Orang(String nama, int umur) {
        this.nama = nama;
        this.umur = umur;
    }

    // Getter dan Setter (wajib untuk JPA)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    @Override
    public String toString() {
        return "Orang{" +
                "id=" + id +
                ", nama='" + nama + '\'' +
                ", umur=" + umur +
                '}';
    }
}
