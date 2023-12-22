package ru.nsu.ooad.aemsdemo.dto;

/**
 * Текст лабораторного журнала, часть его контента.
 *
 * @param text Текст журнала.
 */
public record JournalTextResponseDto(String text) {
    public JournalTextResponseDto {
        if (text == null) {
            throw new IllegalArgumentException("текст журнала не должен быть null");
        }
    }
}
