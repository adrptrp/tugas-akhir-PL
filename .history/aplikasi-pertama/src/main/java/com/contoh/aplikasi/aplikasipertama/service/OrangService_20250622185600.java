package com.contoh.aplikasi.aplikasipertama.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.contoh.aplikasi.aplikasipertama.model.Orang;
import com.contoh.aplikasi.aplikasipertama.repository.OrangRepository;

@Service
public class OrangService {

    private final OrangRepository orangRepository;

    // Constructor Injection
    public OrangService(OrangRepository orangRepository) {
        this.orangRepository = orangRepository;
        
        // Tambahkan data awal jika database kosong
        if (orangRepository.count() == 0) {
            orangRepository.save(new Orang("John Doe", 30));
            orangRepository.save(new Orang("Jane Smith", 24));
            System.out.println("Data awal ditambahkan ke H2 Database!");
        }
    }

    public List<Orang> getAllOrang() {
        return orangRepository.findAll();
    }

    public Optional<Orang> getOrangById(Long id) {
        return orangRepository.findById(id);
    }

    public Orang addOrang(Orang orang) {
        return orangRepository.save(orang);
    }

    public Optional<Orang> updateOrang(Long id, Orang orangBaru) {
        return orangRepository.findById(id).map(existingOrang -> {
            existingOrang.setNama(orangBaru.getNama());
            existingOrang.setUmur(orangBaru.getUmur());
            return orangRepository.save(existingOrang);
        });
    }

    public boolean deleteOrang(Long id) {
        if (orangRepository.existsById(id)) {
            orangRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Query method kustom
    public List<Orang> findOrangByNama(String nama) {
        return orangRepository.findByNama(nama);
    }
}
