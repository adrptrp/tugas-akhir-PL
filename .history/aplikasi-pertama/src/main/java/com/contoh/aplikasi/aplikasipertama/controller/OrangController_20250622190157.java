    @GetMapping("/search/by-nama")
    public List<Orang> getOrangByNama(@RequestParam String nama) {
        return orangService.findOrangByNama(nama);
    }
    
    @GetMapping("/nama/{nama}")
    public ResponseEntity<List<Orang>> getOrangByNamaPath(@PathVariable String nama) {
        List<Orang> orangList = orangService.findOrangByNama(nama);
        return orangList.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(orangList);
    }
