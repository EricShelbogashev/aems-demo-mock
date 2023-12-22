package ru.nsu.ooad.aemsdemo.dto;

import java.time.*;

/**
 * Запись журнала для отображения в каталоге журналов.
 *
 * @param id        Идентификатор журнала.
 * @param title     Заголовок журнала.
 * @param createdAt Когда создан.
 * @param updatedAt Когда последний раз обновлен.
 */
public record JournalEntryResponseDto(
        Long id,
        String title,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public JournalEntryResponseDto {
        if (id == null) {
            throw new IllegalArgumentException("идентификатор журнала не должен быть null");
        }
        if (title == null) {
            throw new IllegalArgumentException("заголовок журнала не должен быть null");
        }
        if (createdAt == null) {
            throw new IllegalArgumentException("время создания не должно быть null");
        }
        if (updatedAt == null) {
            throw new IllegalArgumentException("время обновления не должно быть null");
        }
    }
}
