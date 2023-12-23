package ru.nsu.ooad.aemsdemo.api.v1.catalogue;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import ru.nsu.ooad.aemsdemo.dto.*;

import javax.validation.*;
import java.util.*;
import ru.nsu.ooad.aemsdemo.service.CatalogueService;

@RestController
@RequestMapping("v1/catalogs/reagents")
public class ReagentCatalogueController {

    private final CatalogueService catalogueService;

    /**
     * Конструктор для контроллера каталога реагентов.
     *
     * @param catalogueService Сервис для управления реагентами.
     */
    public ReagentCatalogueController(CatalogueService catalogueService) {
        this.catalogueService = catalogueService;
    }

    /**
     * Получает все реагенты.
     *
     * @return ResponseEntity со списком DTO реагентов.
     */
    @GetMapping
    public ResponseEntity<List<ReagentResponseDto>> getAllReagents() {
        return ResponseEntity.ok(
                catalogueService.getReagentResponseDtos()
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
                catalogueService.addReagent(reagentDto)
        );
    }

}
