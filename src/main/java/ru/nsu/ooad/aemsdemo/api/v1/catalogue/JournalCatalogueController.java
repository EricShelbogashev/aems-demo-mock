package ru.nsu.ooad.aemsdemo.api.v1.catalogue;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import ru.nsu.ooad.aemsdemo.dto.*;
import ru.nsu.ooad.aemsdemo.factory.*;

import java.util.*;

@RestController
@RequestMapping("v1/catalogs/journals")
public class JournalCatalogueController {

    private final CommonDataHolder dataHolder;

    public JournalCatalogueController(CommonDataHolder dataHolder) {
        this.dataHolder = dataHolder;
    }

    @GetMapping
    public ResponseEntity<List<JournalEntryResponseDto>> getAllJournalEntries() {
        return ResponseEntity.ok(
                dataHolder.getJournalEntryResponseDtos()
        );
    }

    @PostMapping
    public ResponseEntity<JournalEntryResponseDto> createJournalEntry(@RequestBody JournalEntryRequestDto entryDto) {
        return ResponseEntity.ok(
                dataHolder.addJournalEntry(entryDto)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<JournalEntryResponseDto> updateJournalEntry(@PathVariable Long id,
                                                                      @RequestBody JournalEntryRequestDto entryDto) {
        return ResponseEntity.ok(
                dataHolder.updateJournalEntry(id, entryDto)
        );
    }

}