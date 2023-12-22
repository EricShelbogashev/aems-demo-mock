package ru.nsu.ooad.aemsdemo.api.v1.catalogue;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import ru.nsu.ooad.aemsdemo.dto.*;
import ru.nsu.ooad.aemsdemo.factory.*;

import java.util.*;

@RestController
@RequestMapping("v1/catalogs/reagents")
public class ReagentCatalogueController {

    private final CommonDataHolder dataHolder;

    public ReagentCatalogueController(CommonDataHolder dataHolder) {
        this.dataHolder = dataHolder;
    }

    @GetMapping
    public ResponseEntity<List<ReagentResponseDto>> getAllReagents() {
        return ResponseEntity.ok(
                dataHolder.getReagentResponseDtos()
        );
    }

    @PostMapping
    public ResponseEntity<ReagentResponseDto> createReagent(@RequestBody ReagentRequestDto reagentDto) {
        return ResponseEntity.ok(
                dataHolder.addReagent(reagentDto)
        );
    }

}