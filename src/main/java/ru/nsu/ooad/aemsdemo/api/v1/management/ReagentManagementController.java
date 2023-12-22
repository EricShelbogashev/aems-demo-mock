package ru.nsu.ooad.aemsdemo.api.v1.management;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.*;
import ru.nsu.ooad.aemsdemo.dto.*;

import java.util.*;

@RestController
@RequestMapping("v1/management/reagents/{id}")
public class ReagentManagementController {

    @PutMapping
    public ResponseEntity<ReagentResponseDto> updateReagent(@PathVariable Long id,
                                                            @RequestBody ReagentRequestDto reagentDto) {
        throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED, "Method not implemented");
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteReagent(@PathVariable Long id) {
        throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED, "Method not implemented");
    }

    @GetMapping("/consumption-stats")
    public ResponseEntity<List<ReagentUsageResponseDto>> getReagentConsumptionStats(@PathVariable String id) {
        throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED, "Method not implemented");
    }
}