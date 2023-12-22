package ru.nsu.ooad.aemsdemo.dto;

import jakarta.validation.constraints.*;

/**
 * DTO (Data Transfer Object) для запроса использования реагента.
 * Этот класс используется для передачи данных об испоользовании реагента от клиента к серверу.
 *
 * @param reagentId Идентификатор реагента. Не может быть null.
 * @param journalId Идентификатор записи журнала, связанной с использованием реагента. Не может быть null.
 * @param reason    Причина использования реагента. Не может быть null.
 * @param quantity  Количество используемого реагента. Должно быть положительным числом.
 * @param unit      Единица измерения количества реагента. Не может быть null.
 */
public record ReagentUsageRequestDto(
        @NotNull(message = "идентификатор реагента не может быть null")
        Long reagentId,
        Long journalId,
        @NotNull(message = "причина использования не может быть null")
        UsageReason reason,
        @NotNull(message = "количество не может быть null")
        @Positive(message = "количество должно быть положительным числом")
        Double quantity,
        @NotNull(message = "единица измерения не может быть null")
        Unit unit
) {
}
