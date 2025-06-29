@GetMapping("/search/by-nama")
public List<Orang> getOrangByNama(@RequestParam String nama) {
    return orangService.findOrangByNama(nama);
}
