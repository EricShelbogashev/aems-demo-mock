package ru.nsu.ooad.aemsdemo.factory;

import jakarta.annotation.*;
import org.springframework.stereotype.*;
import ru.nsu.ooad.aemsdemo.dto.*;
import ru.nsu.ooad.aemsdemo.factory.exception.catalogue.*;

import java.time.*;
import java.util.*;

@Component
public class CommonDataHolder {
    private final Map<Long, JournalEntryResponseDto> journalMap = new HashMap<>();

    @PostConstruct
    void init() {
        for (long i = 1; i <= 47; i++) {
            LocalDateTime date = LocalDateTime.of(2023, Month.JANUARY.getValue() + new Random().nextInt(12),
                    1 + new Random().nextInt(28),
                    new Random().nextInt(24),
                    new Random().nextInt(60));
            journalMap.put(i, new JournalEntryResponseDto(
                    i,
                    "Lab Journal Entry " + i,
                    date,
                    date.plusDays(new Random().nextInt(10))
            ));
        }
    }

    public Map<Long, JournalEntryResponseDto> getJournalEntryResponseDtoMap() {
        return journalMap;
    }


    public JournalEntryResponseDto addJournalEntry(JournalEntryRequestDto entryDto) {
        Long id = journalMap.keySet().stream().max(Long::compareTo).orElse(0L);
        return journalMap.put(
                id,
                new JournalEntryResponseDto(
                        id,
                        entryDto.title(),
                        LocalDateTime.now(),
                        LocalDateTime.now()
                )
        );
    }

    public JournalEntryResponseDto updateJournalEntry(Long id, JournalEntryRequestDto entryDto) {
        if (!journalMap.containsKey(id)) {
            throw new JournalCatalogueException("запрашиваемый журнал не существует");
        }
        return journalMap.computeIfPresent(
                id,
                (key, value) -> new JournalEntryResponseDto(
                        id,
                        entryDto.title(),
                        value.createdAt(),
                        LocalDateTime.now()
                )
        );
    }
}
