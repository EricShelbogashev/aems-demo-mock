package ru.nsu.ooad.aemsdemo.dto;

import java.util.*;

/**
 * Класс передачи данных (DTO), представляющий ответ с ошибкой.
 */
public record ErrorResponseDto(String summary, List<String> errors) {
    /**
     * Создает объект ErrorResponseDto с предоставленным сообщением об ошибке.
     *
     * @param summary Резюме ошибки. Не должно быть null.
     * @param errors  Сообщения всех зарегистрированных исключений. Не должны быть null.
     * @throws IllegalArgumentException если предоставленное сообщение является null.
     */
    public ErrorResponseDto {
        if (errors == null) {
            throw new IllegalArgumentException("сообщения об ошибке не должны быть null");
        }

        boolean containsNull = errors.stream().anyMatch(Objects::isNull);
        if (containsNull) {
            throw new IllegalArgumentException("сообщения об ошибке не должны быть null");
        }

        if (summary == null) {
            throw new IllegalArgumentException("резюме ошибки не должно быть null");
        }
    }
}
