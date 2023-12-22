package ru.nsu.ooad.aemsdemo.api.v1.management;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import ru.nsu.ooad.aemsdemo.dto.*;
import ru.nsu.ooad.aemsdemo.factory.*;

import javax.validation.*;
import java.util.*;

@RestController
@RequestMapping("v1/management/reagents/{id}")
public class ReagentManagementController {

    /**
     * Хранилище общих данных, используемое для доступа к записям журнала.
     */
    private final CommonDataHolder dataHolder;

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
                                                            @Valid @RequestBody ReagentRequestDto reagentDto) {
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
    public ResponseEntity<MessageResponseDto> deleteReagent(@PathVariable Long id) {
        dataHolder.deleteReagent(id);
        return ResponseEntity.ok(
                new MessageResponseDto("реактив успешно удален")
        );
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
