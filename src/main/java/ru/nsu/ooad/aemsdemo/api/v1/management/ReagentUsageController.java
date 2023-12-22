package ru.nsu.ooad.aemsdemo.api.v1.management;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.*;
import ru.nsu.ooad.aemsdemo.dto.*;

@RestController
@RequestMapping("v1/management/usage-entries")
public class ReagentUsageController {


    @GetMapping("/usage-stats")
    public ResponseEntity<JournalEntryResponseDto> getUsageStats() {
        throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED, "Method not implemented");
    }

}
