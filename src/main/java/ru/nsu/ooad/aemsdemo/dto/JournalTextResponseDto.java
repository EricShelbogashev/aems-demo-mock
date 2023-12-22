package ru.nsu.ooad.aemsdemo.dto;

import java.time.*;

public record JournalTextResponseDto(
        Long id,
        String text,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
