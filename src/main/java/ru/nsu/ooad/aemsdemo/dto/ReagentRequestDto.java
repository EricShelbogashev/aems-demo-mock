package ru.nsu.ooad.aemsdemo.dto;

public record ReagentRequestDto(
        String name,
        String latexFormula,
        Double molarWeight,
        String description,
        String hazardCategory
) {
}
