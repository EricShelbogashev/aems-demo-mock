package ru.nsu.ooad.aemsdemo.dto;

import java.time.*;

public record ReagentUsageResponseDto(
        Long usageId,
        Long reagentId,
        Long journalId,
        UsageReason reason,
        Double quantity,
        Unit unit,
        LocalDateTime updatedAt,
        LocalDateTime createdAt
) {
}
