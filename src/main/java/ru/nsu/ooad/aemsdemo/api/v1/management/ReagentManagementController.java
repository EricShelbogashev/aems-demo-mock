package ru.nsu.ooad.aemsdemo.api.v1.management;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import ru.nsu.ooad.aemsdemo.dto.*;
import ru.nsu.ooad.aemsdemo.factory.*;

import java.util.*;

@RestController
@RequestMapping("v1/management/reagents/{id}")
public class ReagentManagementController {

    private final CommonDataHolder dataHolder;

    public ReagentManagementController(CommonDataHolder dataHolder) {
        this.dataHolder = dataHolder;
    }

    @PutMapping
    public ResponseEntity<ReagentResponseDto> updateReagent(@PathVariable Long id,
                                                            @RequestBody ReagentRequestDto reagentDto) {
        return ResponseEntity.ok(
                dataHolder.updateReagent(id, reagentDto)
        );
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteReagent(@PathVariable Long id) {
        dataHolder.deleteReagent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/consumption-stats")
    public ResponseEntity<List<ReagentUsageResponseDto>> getReagentConsumption(@PathVariable Long id) {
        return ResponseEntity.ok(
                dataHolder.getConsumptionByReagent(id)
        );
    }
}