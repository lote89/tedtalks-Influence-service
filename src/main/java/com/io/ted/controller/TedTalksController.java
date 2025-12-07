package com.io.ted.controller;

import com.io.ted.dto.SpeakerInfluenceDto;
import com.io.ted.model.TedTalk;
import com.io.ted.repository.TedTalkRepository;
import com.io.ted.service.CsvImportService;
import com.io.ted.service.InfluenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TedController {

    private final TedTalksImportService csv;
    private final TedTalksRepository repo;
    private final TedTalksInfluenceService influence;

    public TedTalksTedController(TedTalksImportService csv, TedTalksRepository repo, TedTalksInfluenceService influence) {
        this.csv = csv;
        this.repo = repo;
        this.influence = influence;
    }

    @PostMapping("/import")
    public ResponseEntity<?> importCsv(@RequestParam("file") MultipartFile file) {
        try {
            int count = csv.importCsv(file);
            return ResponseEntity.ok("Imported: " + count);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error importing CSV");
        }
    }

    @GetMapping("/talks")
    public List<TedTalk> getAll() {
        return repo.findAll();
    }

    @GetMapping("/influence")
    public List<SpeakerInfluenceDto> ranking() {
        return influence.ranking();
    }
}
