package ru.nsu.ooad.aemsdemo.api.catalog;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.*;
import ru.nsu.ooad.aemsdemo.api.*;
import ru.nsu.ooad.aemsdemo.dto.*;

import java.util.*;

@RestController
@RequestMapping("catalogs/journals")
public class JournalCatalogueController implements BaseController {

    @GetMapping
    public ResponseEntity<List<JournalEntryResponseDto>> getAllJournalEntries() {
        throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED, "Method not implemented");
    }

    @PostMapping
    public ResponseEntity<JournalEntryResponseDto> createJournalEntry(@RequestBody JournalEntryRequestDto entryDto) {
        throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED, "Method not implemented");
    }

    @PutMapping("/{id}")
    public ResponseEntity<JournalEntryResponseDto> updateJournalEntry(@PathVariable Long id,
                                                                      @RequestBody JournalEntryRequestDto entryDto) {
        throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED, "Method not implemented");
    }

}