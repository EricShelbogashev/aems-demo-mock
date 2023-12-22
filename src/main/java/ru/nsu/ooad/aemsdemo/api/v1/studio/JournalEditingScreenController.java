package ru.nsu.ooad.aemsdemo.api.v1.studio;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.*;
import ru.nsu.ooad.aemsdemo.dto.*;
import ru.nsu.ooad.aemsdemo.factory.*;

@RestController
@RequestMapping("v1/sources/journals/{journalId}")
public class JournalEditingScreenController {

    private final CommonDataHolder dataHolder;

    /**
     * Конструктор для контроллера экрана редактирования журнала.
     *
     * @param dataHolder Хранилище общих данных, используемое для управления содержимым журнала.
     */
    public JournalEditingScreenController(CommonDataHolder dataHolder) {
        this.dataHolder = dataHolder;
    }

    /**
     * Получает содержимое журнала.
     *
     * @param journalId Идентификатор журнала, содержимое которого нужно получить.
     * @return ResponseEntity с DTO содержимого журнала.
     */
    @GetMapping
    public ResponseEntity<JournalContentResponseDto> getContent(@PathVariable Long journalId) {
        return ResponseEntity.ok(
                dataHolder.getJournalContent(journalId)
        );
    }

    /**
     * Обновляет текст в журнале.
     *
     * @param journalId Идентификатор журнала, текст которого нужно обновить.
     * @param textDto   DTO с новым текстом для журнала.
     * @return ResponseEntity с DTO обновленного текста журнала.
     */
    @PostMapping
    public ResponseEntity<JournalTextResponseDto> updateText(@PathVariable Long journalId,
                                                             @RequestBody JournalTextRequestDto textDto) {
        return ResponseEntity.ok(
                dataHolder.updateText(journalId, textDto)
        );
    }

    /**
     * Добавляет запись об использовании реагента в журнал.
     *
     * @param journalId Идентификатор журнала, к которому добавляется запись об использовании.
     * @param usageDto  DTO с данными об использовании реагента.
     * @return ResponseEntity с DTO добавленной записи об использовании реагента.
     */
    @PostMapping("/usages")
    public ResponseEntity<ReagentUsageResponseDto> addUsage(@PathVariable Long journalId,
                                                            @RequestBody ReagentUsageRequestDto usageDto) {
        return ResponseEntity.ok(
                dataHolder.addUsage(journalId, usageDto)
        );
    }

    /**
     * Удаляет запись об использовании реагента из журнала.
     *
     * @param journalId Идентификатор журнала, из которого удаляется запись.
     * @param usageId   Идентификатор записи об использовании, которую необходимо удалить.
     * @return ResponseEntity без содержимого.
     */
    @DeleteMapping("/usages/{usageId}")
    public ResponseEntity<Void> deleteUsage(@PathVariable Long journalId, @PathVariable Long usageId) {
        dataHolder.deleteUsage(journalId, usageId);
        return ResponseEntity.ok().build();
    }

    /**
     * Удаляет запись журнала.
     *
     * @param journalId Идентификатор удаляемой записи журнала.
     * @return ResponseEntity без содержимого.
     * @throws HttpServerErrorException если метод не реализован.
     */
    @DeleteMapping
    public ResponseEntity<Void> deleteJournalEntry(@PathVariable Long journalId) {
        throw new HttpServerErrorException(HttpStatus.NOT_IMPLEMENTED, "Method not implemented");
    }
}
