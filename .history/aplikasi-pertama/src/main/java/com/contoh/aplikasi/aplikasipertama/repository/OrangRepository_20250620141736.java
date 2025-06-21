package com.contoh.aplikasi.aplikasipertama.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contoh.aplikasi.aplikasipertama.model.Orang;

@Repository
public interface OrangRepository extends JpaRepository<Orang, Long> {

    // Query Methods - Spring Data JPA akan auto-generate implementasinya
    List<Orang> findByNama(String nama);
    List<Orang> findByUmurGreaterThan(int umur);
    Optional<Orang> findByNamaAndUmur(String nama, int umur);
}
