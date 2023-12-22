package ru.nsu.ooad.aemsdemo.dto;

import javax.validation.constraints.*;

/**
 * DTO для запроса, содержащего текст записи журнала.
 * Этот класс используется для передачи текстовых данных от клиента к серверу.
 *
 * @param text Текст записи журнала. Этот текст не может быть null и не должен быть пустым.
 *             Валидация на отсутствие пустых значений обеспечивается с помощью аннотации @NotBlank.
 */
public record JournalTextRequestDto(
        @NotBlank(message = "Текст записи не может быть пустым")
        String text
) {
}
