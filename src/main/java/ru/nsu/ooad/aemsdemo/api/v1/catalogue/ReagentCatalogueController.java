package ru.nsu.ooad.aemsdemo.api.v1.catalogue;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import ru.nsu.ooad.aemsdemo.dto.*;
import ru.nsu.ooad.aemsdemo.factory.*;

import java.util.*;
import ru.nsu.ooad.aemsdemo.service.ReagentService;

@RestController
@RequestMapping("v1/catalogs/reagents")
public class ReagentCatalogueController {

    private final ReagentService reagentService;

    /**
     * Конструктор для контроллера каталога реагентов.
     *
     * @param reagentService Сервис для управления реагентами.
     */
    public ReagentCatalogueController(ReagentService reagentService) {
        this.reagentService = reagentService;
    }

    /**
     * Получает все реагенты.
     *
     * @return ResponseEntity со списком DTO реагентов.
     */
    @GetMapping
    public ResponseEntity<List<ReagentResponseDto>> getAllReagents() {
        return ResponseEntity.ok(
                reagentService.getReagentResponseDtos()
        );
    }

    /**
     * Создает новый реагент.
     *
     * @param reagentDto DTO для создания реагента.
     * @return ResponseEntity с DTO созданного реагента.
     */
    @PostMapping
    public ResponseEntity<ReagentResponseDto> createReagent(@RequestBody ReagentRequestDto reagentDto) {
        return ResponseEntity.ok(
                reagentService.addReagent(reagentDto)
        );
    }

}
