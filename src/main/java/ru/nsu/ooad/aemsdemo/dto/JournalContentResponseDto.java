package ru.nsu.ooad.aemsdemo.dto;

import java.util.*;

public record JournalContentResponseDto(
        Long id,
        String title,
        JournalTextResponseDto journalTextDto,
        List<ReagentUsageResponseDto> usages
) {
}
