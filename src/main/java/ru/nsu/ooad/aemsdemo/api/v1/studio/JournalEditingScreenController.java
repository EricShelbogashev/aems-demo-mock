package ru.nsu.ooad.aemsdemo.api.v1.studio;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.*;
import ru.nsu.ooad.aemsdemo.dto.*;
import ru.nsu.ooad.aemsdemo.factory.*;

@RestController
@RequestMapping("v1/sources/journals/{journalId}")
public class JournalEditingScreenController {

    private final CommonDataHolder dataHolder;

    public JournalEditingScreenController(CommonDataHolder dataHolder) {
        this.dataHolder = dataHolder;
    }

    @GetMapping
    public ResponseEntity<JournalContentResponseDto> getContent(@PathVariable Long journalId) {
        return ResponseEntity.ok(
                dataHolder.getJournalContent(journalId)
        );
    }

    @PostMapping
    public ResponseEntity<JournalTextResponseDto> updateText(@PathVariable Long journalId,
                                                             @RequestBody JournalTextRequestDto textDto) {
        return ResponseEntity.ok(
                dataHolder.updateText(journalId, textDto)
        );
    }

    @PostMapping("/usages")
    public ResponseEntity<ReagentUsageResponseDto> addUsage(@PathVariable Long journalId,
                                                            @RequestBody ReagentUsageRequestDto usageDto) {
        return ResponseEntity.ok(
                dataHolder.addUsage(journalId, usageDto)
        );
    }

    @DeleteMapping("/usages/{usageId}")
    public ResponseEntity<Void> deleteUsage(@PathVariable Long journalId, @PathVariable Long usageId) {
        return ResponseEntity.ok(
                dataHolder.deleteUsage(journalId, usageId)
        );
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteJournalEntry(@PathVariable Long journalId) {
        throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED, "Method not implemented");
    }
}