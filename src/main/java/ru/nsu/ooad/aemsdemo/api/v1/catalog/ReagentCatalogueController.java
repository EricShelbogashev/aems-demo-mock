package ru.nsu.ooad.aemsdemo.api.v1.catalog;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.*;
import ru.nsu.ooad.aemsdemo.dto.*;

import java.util.*;

@RestController
@RequestMapping("v1/catalogs/reagents")
public class ReagentCatalogueController {

    @GetMapping
    public ResponseEntity<List<ReagentResponseDto>> getAllReagents() {
        throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED, "Method not implemented");
    }

    @PostMapping
    public ResponseEntity<ReagentResponseDto> createReagent(@RequestBody ReagentRequestDto reagentDto) {
        throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED, "Method not implemented");
    }

}