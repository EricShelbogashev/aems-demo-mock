package ru.nsu.ooad.aemsdemo.api.v1.studio;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.*;
import ru.nsu.ooad.aemsdemo.dto.*;

@RestController
@RequestMapping("v1/sources/journals/{journalId}")
public class JournalEditingScreenController {

    @GetMapping
    public ResponseEntity<JournalContentResponseDto> getContent(@PathVariable Long journalId) {
        throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED, "Method not implemented");
    }

    @PostMapping
    public ResponseEntity<JournalTextResponseDto> updateText(@PathVariable Long journalId,
                                                             @RequestBody JournalTextRequestDto textDto) {
        throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED, "Method not implemented");
    }

    @PostMapping("/usages")
    public ResponseEntity<ReagentUsageResponseDto> addUsage(@PathVariable Long journalId,
                                                            @RequestBody ReagentUsageRequestDto usageDto) {
        throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED, "Method not implemented");
    }

    @DeleteMapping("/usages/{usageId}")
    public ResponseEntity<Void> deleteUsage(@PathVariable Long journalId, @PathVariable String usageId) {
        throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED, "Method not implemented");
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteJournalEntry(@PathVariable Long journalId) {
        throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED, "Method not implemented");
    }
}