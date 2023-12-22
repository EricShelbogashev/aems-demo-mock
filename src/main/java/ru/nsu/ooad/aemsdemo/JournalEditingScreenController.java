package ru.nsu.ooad.aemsdemo;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.*;

import java.util.*;

@RestController
@RequestMapping("journals/{id}/content")
public class JournalEditingScreenController {

    @GetMapping
    public ResponseEntity<List<JournalEntryDTO>> getContent(@PathVariable Long id) {
        throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED, "Method not implemented");
    }

    @PostMapping
    public ResponseEntity<JournalEntryDTO> updateText(@PathVariable Long id, @RequestBody JournalEntryDTO entryDto) {
        throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED, "Method not implemented");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> addUsage(@PathVariable Long id) {
        throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED, "Method not implemented");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJournalEntry(@PathVariable Long id) {
        throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED, "Method not implemented");
    }
}