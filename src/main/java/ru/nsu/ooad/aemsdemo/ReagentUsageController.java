package ru.nsu.ooad.aemsdemo;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.*;

@RestController
@RequestMapping("/analytics")
public class ReagentUsageController {


    @GetMapping("/usage-stats")
    public ResponseEntity<JournalEntryDTO> getUsageStats() {
        throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED, "Method not implemented");
    }

}
