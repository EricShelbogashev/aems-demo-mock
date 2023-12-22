package ru.nsu.ooad.aemsdemo.api.v1.management;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import ru.nsu.ooad.aemsdemo.dto.*;
import ru.nsu.ooad.aemsdemo.factory.*;

import java.util.*;

@RestController
@RequestMapping("v1/management/usage-entries")
public class ReagentUsageController {

    /**
     * Хранилище общих данных, используемое для доступа к записям журнала.
     */
    private final CommonDataHolder dataHolder;

    public ReagentUsageController(CommonDataHolder dataHolder) {
        this.dataHolder = dataHolder;
    }

    /**
     * Получает статистику использования всех реагентов.
     *
     * @return ResponseEntity со списком DTO, отражающим статистику использования реагентов.
     */
    @GetMapping
    public ResponseEntity<List<ReagentUsageResponseDto>> getStats() {
        return ResponseEntity.ok(
                dataHolder.getConsumptions()
        );
    }

}
