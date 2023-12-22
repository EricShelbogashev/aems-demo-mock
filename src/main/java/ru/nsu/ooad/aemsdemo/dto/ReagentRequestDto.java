package ru.nsu.ooad.aemsdemo.dto;

import jakarta.validation.constraints.*;

/**
 * DTO (Data Transfer Object) для запроса данных о реагенте.
 * Этот класс используется для передачи данных о реагенте от клиента к серверу.
 *
 * @param name           Название реагента. Не может быть null и не должно быть пустым.
 * @param latexFormula   Формула реагента в формате LaTeX. Не должна быть null.
 * @param molarWeight    Молярная масса реагента. Должна быть положительным числом.
 * @param description    Описание реагента. Может быть null.
 * @param hazardCategory Категория опасности реагента. Не должна быть null.
 */
public record ReagentRequestDto(
        @NotBlank(message = "Название реагента не может быть пустым")
        String name,
        @NotBlank(message = "Формула реагента не может быть пустой")
        String latexFormula,
        @NotNull(message = "Молярная масса не может быть null")
        @Positive(message = "Молярная масса должна быть положительным числом")
        Double molarWeight,
        String description,
        @NotNull(message = "Категория опасности не может быть null")
        HazardCategory hazardCategory
) {
}
