package ru.nsu.ooad.aemsdemo.dto;

import java.time.LocalDateTime;

public record ReagentResponseDto(
        Long id,
        String name,
        String latexFormula,
        Double molarWeight,
        String description,
        HazardCategory hazardCategory,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
