package ru.nsu.ooad.aemsdemo.api.v1.management;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.*;
import ru.nsu.ooad.aemsdemo.dto.*;
import ru.nsu.ooad.aemsdemo.factory.*;

import java.util.*;

@RestController
@RequestMapping("v1/management/usage-entries")
public class ReagentUsageController {

    private final CommonDataHolder dataHolder;

    public ReagentUsageController(CommonDataHolder dataHolder) {
        this.dataHolder = dataHolder;
    }

    @GetMapping("/stats")
    public ResponseEntity<List<ReagentUsageResponseDto>> getStats() {
        return ResponseEntity.ok(
                dataHolder.getConsumptions()
        );
    }

}
