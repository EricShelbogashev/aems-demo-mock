package ru.nsu.ooad.aemsdemo;

import java.util.*;

public record JournalEntryDTO(
        Long id,
        String title,
        String content,
        Date dateCreated
) {
}
