package ru.nsu.ooad.aemsdemo.api.v1.catalogue;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import ru.nsu.ooad.aemsdemo.dto.*;
import ru.nsu.ooad.aemsdemo.factory.*;

import javax.validation.*;
import java.util.*;

@RestController
@RequestMapping("v1/catalogs/reagents")
public class ReagentCatalogueController {

    private final CommonDataHolder dataHolder;

    /**
     * Конструктор для контроллера каталога реагентов.
     *
     * @param dataHolder Хранилище общих данных, используемое для управления реагентами.
     */
    public ReagentCatalogueController(CommonDataHolder dataHolder) {
        this.dataHolder = dataHolder;
    }

    /**
     * Получает все реагенты.
     *
     * @return ResponseEntity со списком DTO реагентов.
     */
    @GetMapping
    public ResponseEntity<List<ReagentResponseDto>> getAllReagents() {
        return ResponseEntity.ok(
                dataHolder.getReagentResponseDtos()
        );
    }

    /**
     * Создает новый реагент.
     *
     * @param reagentDto DTO для создания реагента.
     * @return ResponseEntity с DTO созданного реагента.
     */
    @PostMapping
    public ResponseEntity<ReagentResponseDto> createReagent(@Valid @RequestBody ReagentRequestDto reagentDto) {
        return ResponseEntity.ok(
                dataHolder.addReagent(reagentDto)
        );
    }

}
