package ru.nsu.ooad.aemsdemo.api.v1.management;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import ru.nsu.ooad.aemsdemo.dto.*;

import java.util.*;
import ru.nsu.ooad.aemsdemo.service.ManagementService;

@RestController
@RequestMapping("v1/management/usage-entries")
public class ReagentUsageController {

    /**
     * Хранилище общих данных, используемое для доступа к записям журнала.
     */
    private final ManagementService managementService;

    public ReagentUsageController(ManagementService managementService) {
        this.managementService = managementService;
    }

    /**
     * Получает статистику использования всех реагентов.
     *
     * @return ResponseEntity со списком DTO, отражающим статистику использования реагентов.
     */
    @GetMapping
    public ResponseEntity<List<ReagentUsageResponseDto>> getStats() {
        return ResponseEntity.ok(
                managementService.getConsumptions()
        );
    }

}
