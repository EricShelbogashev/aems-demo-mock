package ru.nsu.ooad.aemsdemo.dto;

public record ReagentUsageRequestDto(
        Long reagentId,
        Long journalId,
        UsageReason reason,
        Double quantity,
        Unit unit
) {
}
