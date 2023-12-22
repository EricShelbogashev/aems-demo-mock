package ru.nsu.ooad.aemsdemo.dto;

import java.util.*;

public record JournalContentResponseDto(
        Long id,
        String title,
        Date createdAt,
        Date updatedAt
) {
}
