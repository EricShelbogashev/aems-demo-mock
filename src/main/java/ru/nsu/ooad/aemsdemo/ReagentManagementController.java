package ru.nsu.ooad.aemsdemo;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.*;

import java.util.*;

@RestController
@RequestMapping("/reagent")
public class ReagentManagementController {

    @GetMapping
    public ResponseEntity<List<JournalEntryDTO>> getAllReagents() {
        throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED, "Method not implemented");
    }

    @PostMapping
    public ResponseEntity<JournalEntryDTO> createReagent(@RequestBody JournalEntryDTO reagentDto) {
        throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED, "Method not implemented");
    }

    @PutMapping("/{id}")
    public ResponseEntity<JournalEntryDTO> updateReagent(@PathVariable Long id, @RequestBody JournalEntryDTO reagentDto) {
        throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED, "Method not implemented");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReagent(@PathVariable Long id) {
        throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED, "Method not implemented");
    }

    @GetMapping("/reagent-consumption")
    public ResponseEntity<List<JournalEntryDTO>> getReagentConsumptionStats() {
        throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED, "Method not implemented");
    }
}