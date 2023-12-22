package ru.nsu.ooad.aemsdemo.dto;

import java.time.*;

public record JournalEntryResponseDto(
        Long id,
        String title,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
