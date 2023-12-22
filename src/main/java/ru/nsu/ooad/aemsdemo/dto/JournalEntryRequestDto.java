package ru.nsu.ooad.aemsdemo.dto;

import org.springframework.validation.annotation.*;

import javax.validation.constraints.*;

/**
 * DTO (Data Transfer Object) для запроса создания или обновления записи журнала.
 * Этот класс используется для передачи данных от клиента к серверу при создании или обновлении записи журнала.
 *
 * @param title Заголовок записи журнала. Должен быть не пустым и не может быть null.
 *              Это поле обязательно для заполнения и подлежит валидации на предмет отсутствия пустых значений.
 */
@Validated
public record JournalEntryRequestDto(
        @NotBlank(message = "Заголовок не может быть пустым")
        String title
) {
}
