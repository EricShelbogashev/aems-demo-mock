package ru.nsu.ooad.aemsdemo.dto;

import java.time.LocalDateTime;

/**
 * Запись реагента для отображения в каталоге реагентов.
 *
 * @param id              Идентификатор реагента.
 * @param name            Название реагента.
 * @param latexFormula    Формула реагента в формате LaTeX.
 * @param molarWeight     Молярная масса реагента.
 * @param description     Описание реагента.
 * @param hazardCategory  Категория опасности реагента.
 * @param createdAt       Когда создан.
 * @param updatedAt       Когда последний раз обновлен.
 */
public record ReagentResponseDto(
        Long id,
        String name,
        String latexFormula,
        Double molarWeight,
        String description,
        HazardCategory hazardCategory,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public ReagentResponseDto {
        if (id == null) {
            throw new IllegalArgumentException("идентификатор реагента не должен быть null");
        }
        if (name == null) {
            throw new IllegalArgumentException("название реагента не должно быть null");
        }
        if (latexFormula == null) {
            throw new IllegalArgumentException("формула реагента не должна быть null");
        }
        if (molarWeight == null) {
            throw new IllegalArgumentException("молярная масса реагента не должна быть null");
        }
        if (description == null) {
            throw new IllegalArgumentException("описание реагента не должно быть null");
        }
        if (hazardCategory == null) {
            throw new IllegalArgumentException("категория опасности реагента не должна быть null");
        }
        if (createdAt == null) {
            throw new IllegalArgumentException("время создания не должно быть null");
        }
        if (updatedAt == null) {
            throw new IllegalArgumentException("время обновления не должно быть null");
        }
    }
}
