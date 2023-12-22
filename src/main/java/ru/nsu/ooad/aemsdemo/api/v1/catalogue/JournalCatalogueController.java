package ru.nsu.ooad.aemsdemo.api.v1.catalogue;

import org.springframework.http.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;
import ru.nsu.ooad.aemsdemo.dto.*;
import ru.nsu.ooad.aemsdemo.factory.*;

import java.util.*;

@RestController
@RequestMapping("v1/catalogs/journals")
public class JournalCatalogueController {

    private final CommonDataHolder dataHolder;

    /**
     * Конструктор для контроллера каталога журналов.
     *
     * @param dataHolder Хранилище общих данных, используемое для доступа к записям журнала.
     */
    public JournalCatalogueController(CommonDataHolder dataHolder) {
        this.dataHolder = dataHolder;
    }

    /**
     * Получает все записи журнала.
     *
     * @return ResponseEntity со списком DTO записей журнала.
     */
    @GetMapping
    public ResponseEntity<List<JournalEntryResponseDto>> getAllJournalEntries() {
        return ResponseEntity.ok(
                dataHolder.getJournalEntryResponseDtos()
        );
    }

    /**
     * Создает новую запись журнала.
     *
     * @param entryDto DTO для создания записи журнала.
     * @return ResponseEntity с DTO созданной записи журнала.
     */
    @PostMapping
    public ResponseEntity<JournalEntryResponseDto> createJournalEntry(@RequestBody @Validated JournalEntryRequestDto entryDto) {
        return ResponseEntity.ok(
                dataHolder.addJournalEntry(entryDto)
        );
    }

    /**
     * Обновляет существующую запись журнала.
     *
     * @param id       Идентификатор записи журнала для обновления.
     * @param entryDto DTO с новыми данными для записи журнала.
     * @return ResponseEntity с DTO обновленной записи журнала.
     */
    @PutMapping(path = "/{id}")
    public ResponseEntity<JournalEntryResponseDto> updateJournalEntry(@PathVariable Long id,
                                                                      @RequestBody JournalEntryRequestDto entryDto) {
        return ResponseEntity.ok(
                dataHolder.updateJournalEntry(id, entryDto)
        );
    }

}
