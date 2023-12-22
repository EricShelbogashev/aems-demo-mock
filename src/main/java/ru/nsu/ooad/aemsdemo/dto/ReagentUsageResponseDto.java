package ru.nsu.ooad.aemsdemo.dto;

import java.time.*;

public record ReagentUsageResponseDto(
        Long usageId,
        Long reagentId,
        JournalEntryResponseDto journalEntryResponseDto,
        UsageReason reason,
        Double quantity,
        Unit unit,
        LocalDateTime createdAt
) {
}
