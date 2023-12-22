package ru.nsu.ooad.aemsdemo.dto;

import java.util.*;

/**
 * Контент, содержащийся в лабораторном журнале.
 *
 * @param id             Идентификатор журнала.
 * @param title          Заголовок журнала.
 * @param journalTextDto Текст журнала.
 * @param usages         Статистика использования реактивов в текущем журнале.
 */
public record JournalContentResponseDto(Long id, String title, JournalTextResponseDto journalTextDto,
                                        List<ReagentUsageResponseDto> usages) {
    public JournalContentResponseDto {
        if (id == null) {
            throw new IllegalArgumentException("идентификатор журнала не должен быть null");
        }
        if (title == null) {
            throw new IllegalArgumentException("заголовок журнала не должен быть null");
        }
        if (journalTextDto == null) {
            throw new IllegalArgumentException("текст журнала не должен быть null");
        }
        if (usages == null) {
            throw new IllegalArgumentException("статистики использования реактивов не должны быть null");
        }
    }
}
