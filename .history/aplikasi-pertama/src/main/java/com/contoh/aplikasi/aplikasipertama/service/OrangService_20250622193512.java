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
        
        // Clear database and add initial data to ensure consistency
        orangRepository.deleteAll();
        orangRepository.save(new Orang("Lisa Black", 27));
        orangRepository.save(new Orang("Michael Brown", 32));
        orangRepository.save(new Orang("Sarah Johnson", 29));
        orangRepository.save(new Orang("David Wilson", 35));
        orangRepository.save(new Orang("Emily Davis", 24));
        System.out.println("Database cleared and initial data added to H2 Database on " + new java.util.Date().toString());
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
        // Case-insensitive search
        return orangRepository.findAll().stream()
            .filter(orang -> orang.getNama().equalsIgnoreCase(nama))
            .collect(java.util.stream.Collectors.toList());
    }
    
    public List<Orang> findOrangByUmurGreaterThan(int umur) {
        return orangRepository.findByUmurGreaterThan(umur);
    }
}
