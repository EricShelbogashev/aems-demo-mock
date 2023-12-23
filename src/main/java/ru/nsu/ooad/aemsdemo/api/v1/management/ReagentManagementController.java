package ru.nsu.ooad.aemsdemo.api.v1.management;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import ru.nsu.ooad.aemsdemo.dto.*;

import javax.validation.*;
import java.util.*;
import ru.nsu.ooad.aemsdemo.service.ManagementService;

@RestController
@RequestMapping("v1/management/reagents/{id}")
public class ReagentManagementController {

    private final ManagementService managementService;

    /**
     * Конструктор для контроллера управления реагентами.
     *
     * @param managementService Сервис используемый для управления реагентами.
     */
    public ReagentManagementController(ManagementService managementService) {
        this.managementService = managementService;
    }

    /**
     * Обновляет существующий реагент.
     *
     * @param id Идентификатор реагента для обновления.
     * @param reagentDto DTO с новыми данными для реагента.
     * @return ResponseEntity с DTO обновленного реагента.
     */
    @PutMapping
    public ResponseEntity<ReagentResponseDto> updateReagent(@PathVariable Long id,
                                                            @Valid @RequestBody ReagentRequestDto reagentDto) {
        return ResponseEntity.ok(
                managementService.updateReagent(id, reagentDto)
        );
    }

    /**
     * Удаляет реагент.
     *
     * @param id Идентификатор реагента для удаления.
     * @return ResponseEntity без содержимого.
     */
    @DeleteMapping
    public ResponseEntity<Void> deleteReagent(@PathVariable Long id) {
        managementService.deleteReagent(id);
        return ResponseEntity.ok().build();
    }

    /**
     * Получает статистику использования реагента.
     *
     * @param id Идентификатор реагента для получения статистики использования.
     * @return ResponseEntity со списком DTO использования реагентов.
     */
    @GetMapping("/consumption-stats")
    public ResponseEntity<List<ReagentUsageResponseDto>> getReagentConsumption(@PathVariable Long id) {
        return ResponseEntity.ok(
                managementService.getConsumptionByReagent(id)
        );
    }
}
