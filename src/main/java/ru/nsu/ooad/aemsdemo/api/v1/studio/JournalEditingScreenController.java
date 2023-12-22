package ru.nsu.ooad.aemsdemo.api.v1.studio;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.*;
import ru.nsu.ooad.aemsdemo.dto.*;
import ru.nsu.ooad.aemsdemo.factory.*;

import javax.validation.*;

@RestController
@RequestMapping("v1/sources/journals/{journalId}")
public class JournalEditingScreenController {

    /**
     * Хранилище общих данных, используемое для доступа к записям журнала.
     */
    private final CommonDataHolder dataHolder;

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
                                                             @Valid @RequestBody JournalTextRequestDto textDto) {
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
                                                            @Valid @RequestBody ReagentUsageRequestDto usageDto) {
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
    public ResponseEntity<MessageResponseDto> deleteUsage(@PathVariable Long journalId, @Valid @PathVariable Long usageId) {
        dataHolder.deleteUsage(journalId, usageId);
        return ResponseEntity.ok(
                new MessageResponseDto("реактив успешно удален")
        );
    }

    /**
     * Удаляет запись журнала.
     *
     * @param journalId Идентификатор удаляемой записи журнала.
     * @return ResponseEntity без содержимого.
     * @throws HttpServerErrorException если метод не реализован.
     */
    @DeleteMapping
    public ResponseEntity<MessageResponseDto> deleteJournalEntry(@PathVariable Long journalId) {
        return ResponseEntity.ok(
                new MessageResponseDto("реактив успешно удален")
        );
    }
}
