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

    /**
     * Конструктор для контроллера управления реагентами.
     *
     * @param dataHolder Хранилище общих данных, используемое для управления реагентами.
     */
    public ReagentManagementController(CommonDataHolder dataHolder) {
        this.dataHolder = dataHolder;
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
                                                            @RequestBody ReagentRequestDto reagentDto) {
        return ResponseEntity.ok(
                dataHolder.updateReagent(id, reagentDto)
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
        dataHolder.deleteReagent(id);
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
                dataHolder.getConsumptionByReagent(id)
        );
    }
}
