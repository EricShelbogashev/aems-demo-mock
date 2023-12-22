package ru.nsu.ooad.aemsdemo;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.*;

import java.util.*;

@RestController
@RequestMapping("/journals")
public class JournalCatalogController {

    @GetMapping
    public ResponseEntity<List<JournalEntryDTO>> getAllJournalEntries() {
        throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED, "Method not implemented");
    }

    @PostMapping
    public ResponseEntity<JournalEntryDTO> createJournalEntry(@RequestBody JournalEntryDTO entryDto) {
        throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED, "Method not implemented");
    }

    @PutMapping("/{id}")
    public ResponseEntity<JournalEntryDTO> updateJournalEntry(@PathVariable Long id, @RequestBody JournalEntryDTO entryDto) {
        throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED, "Method not implemented");
    }

}