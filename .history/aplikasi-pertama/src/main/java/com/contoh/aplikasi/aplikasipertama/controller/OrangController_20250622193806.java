package com.contoh.aplikasi.aplikasipertama.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.contoh.aplikasi.aplikasipertama.model.Orang;
import com.contoh.aplikasi.aplikasipertama.service.OrangService;

@RestController
@RequestMapping("/api/v1/orang")
public class OrangController {

    private final OrangService orangService;

    public OrangController(OrangService orangService) {
        this.orangService = orangService;
    }

    @GetMapping
    public List<Orang> getAllOrang() {
        return orangService.getAllOrang();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orang> getOrangById(@PathVariable Long id) {
        Optional<Orang> orang = orangService.getOrangById(id);
        return orang.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Orang addOrang(@RequestBody Orang orang) {
        return orangService.addOrang(orang);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Orang> updateOrang(@PathVariable Long id, @RequestBody Orang orang) {
        Optional<Orang> updatedOrang = orangService.updateOrang(id, orang);
        return updatedOrang.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrang(@PathVariable Long id) {
        boolean deleted = orangService.deleteOrang(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/search/by-nama")
    public List<Orang> getOrangByNama(@RequestParam String nama) {
        return orangService.findOrangByNama(nama);
    }
    
    @GetMapping("/nama/{nama}")
    public ResponseEntity<List<Orang>> getOrangByNamaPath(@PathVariable String nama) {
        List<Orang> orangList = orangService.findOrangByNama(nama);
        return orangList.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(orangList);
    }
    
    @GetMapping("/name/{nama}")
    public ResponseEntity<List<Orang>> getOrangByNamaDirect(@PathVariable String nama) {
        List<Orang> orangList = orangService.findOrangByNama(nama);
        return orangList.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(orangList);
    }

    @GetMapping("/api/v1/orang/name/{name}")
    public ResponseEntity<?> getOrangByName(@PathVariable String name) {
        List<Orang> orangList = orangService.findOrangByNama(name);
        return orangList.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(orangList);
    }

    @GetMapping("/search/by-umur-greater-than")
    public List<Orang> getOrangByUmurGreaterThan(@RequestParam int umur) {
        return orangService.findOrangByUmurGreaterThan(umur);
    }
}
