package ru.nsu.ooad.aemsdemo.dto;

import java.time.*;

/**
 * Запись использования реагента для отображения в журнале использования.
 *
 * @param usageId                  Идентификатор использования реагента.
 * @param reagentId                Идентификатор реагента.
 * @param journalEntryResponseDto  Данные записи журнала.
 * @param reason                   Причина использования реагента.
 * @param quantity                 Количество использованного реагента.
 * @param unit                     Единица измерения количества.
 * @param createdAt                Время создания записи.
 */
public record ReagentUsageResponseDto(
        Long usageId,
        Long reagentId,
        JournalEntryResponseDto journalEntryResponseDto,
        UsageReason reason,
        Double quantity,
        Unit unit,
        LocalDateTime createdAt
) {
    public ReagentUsageResponseDto {
        if (usageId == null) {
            throw new IllegalArgumentException("Идентификатор использования не должен быть null");
        }
        if (reagentId == null) {
            throw new IllegalArgumentException("Идентификатор реагента не должен быть null");
        }
        if (journalEntryResponseDto == null) {
            throw new IllegalArgumentException("Данные записи журнала не должны быть null");
        }
        if (reason == null) {
            throw new IllegalArgumentException("Причина использования не должна быть null");
        }
        if (quantity == null) {
            throw new IllegalArgumentException("Количество не должно быть null");
        }
        if (unit == null) {
            throw new IllegalArgumentException("Единица измерения не должна быть null");
        }
        if (createdAt == null) {
            throw new IllegalArgumentException("Время создания не должно быть null");
        }
    }
}
