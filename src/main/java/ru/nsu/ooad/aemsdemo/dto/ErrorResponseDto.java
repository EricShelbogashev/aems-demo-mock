package ru.nsu.ooad.aemsdemo.dto;

import java.util.*;

/**
 * Класс передачи данных (DTO), представляющий ответ с ошибкой.
 */
public record ErrorResponseDto(List<String> errors) {
    /**
     * Создает объект ErrorResponseDto с предоставленным сообщением об ошибке.
     *
     * @param errors Сообщения об ошибке. Не должны быть null.
     * @throws IllegalArgumentException если предоставленное сообщение является null.
     */
    public ErrorResponseDto {
        if (errors == null) {
            throw new IllegalArgumentException("сообщения об ошибке не должны быть null");
        }
        errors.stream()
                .filter(Objects::isNull)
                .findAny()
                .ifPresent(nul -> {
                    throw new IllegalArgumentException("сообщения об ошибке не должны быть null");
                });
    }
}
