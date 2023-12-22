package ru.nsu.ooad.aemsdemo.dto;

import jakarta.validation.constraints.*;

/**
 * DTO (Data Transfer Object) для запроса данных о реактиве.
 * Этот класс используется для передачи данных о реактиве от клиента к серверу.
 *
 * @param name           Название реактива. Не может быть null и не должно быть пустым.
 * @param latexFormula   Формула реактива в формате LaTeX. Не должна быть null.
 * @param molarWeight    Молярная масса реактива. Должна быть положительным числом.
 * @param description    Описание реактива. Может быть null.
 * @param hazardCategory Категория опасности реактива. Не должна быть null.
 */
public record ReagentRequestDto(
        @NotBlank(message = "название реактива не может быть пустым")
        @Size(max = 256, message = "название не должно превышать 256 символов")
        String name,
        @NotBlank(message = "формула реактива не может быть пустой")
        @Size(max = 256, message = "формула не должна превышать 256 символов")
        String latexFormula,
        @NotNull(message = "молярная масса не может быть null")
        @Positive(message = "молярная масса должна быть положительным числом")
        Double molarWeight,
        String description,
        @NotNull(message = "категория опасности не может быть null")
        HazardCategory hazardCategory
) {
}
