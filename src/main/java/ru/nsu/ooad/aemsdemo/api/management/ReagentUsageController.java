package ru.nsu.ooad.aemsdemo.api.management;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.*;
import ru.nsu.ooad.aemsdemo.api.*;
import ru.nsu.ooad.aemsdemo.dto.*;

@RestController
@RequestMapping("management/usage-entries")
public class ReagentUsageController implements BaseController {


    @GetMapping("/usage-stats")
    public ResponseEntity<JournalEntryResponseDto> getUsageStats() {
        throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED, "Method not implemented");
    }

}
