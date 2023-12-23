package ru.nsu.ooad.aemsdemo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import ru.nsu.ooad.aemsdemo.dto.JournalEntryRequestDto;
import ru.nsu.ooad.aemsdemo.dto.JournalEntryResponseDto;
import ru.nsu.ooad.aemsdemo.factory.exception.catalogue.JournalCatalogueException;
import ru.nsu.ooad.aemsdemo.model.Journal;
import ru.nsu.ooad.aemsdemo.model.Reagent;
import ru.nsu.ooad.aemsdemo.dto.ReagentRequestDto;
import ru.nsu.ooad.aemsdemo.dto.ReagentResponseDto;
import ru.nsu.ooad.aemsdemo.factory.exception.catalogue.ReagentCatalogueException;
import ru.nsu.ooad.aemsdemo.repository.JournalRepository;
import ru.nsu.ooad.aemsdemo.repository.ReagentRepository;
import ru.nsu.ooad.aemsdemo.service.utils.Converter;

@Service
public class CatalogueService {
    private final JournalRepository journalRepository;
    private final ReagentRepository reagentRepository;

    public CatalogueService(ReagentRepository reagentRepository, JournalRepository journalRepository) {
        this.reagentRepository = reagentRepository;
        this.journalRepository = journalRepository;
    }

    public List<ReagentResponseDto> getReagentResponseDtos() {
        try {
            List<Reagent> all = reagentRepository.findAll();
            return all.stream().map(Converter::reagentToDTO).toList();
        } catch (Exception e) {
            throw new ReagentCatalogueException(e.getMessage());
        }
    }

    public ReagentResponseDto addReagent(ReagentRequestDto reagentDto) {
        try {

            Reagent oldReagent = reagentRepository.findByTitle(reagentDto.name());
            if (oldReagent != null) {
                throw new ReagentCatalogueException("Реагент с таким именем уже существует");
            }
            Reagent reagent = reagentRepository.save(
                    new Reagent(reagentDto.name(), reagentDto.latexFormula(), reagentDto.molarWeight(),
                            reagentDto.description(), Converter.hazardCategoryDtoToDomain(reagentDto.hazardCategory()),
                            LocalDateTime.now(), LocalDateTime.now()));
            return Converter.reagentToDTO(reagent);
        }catch (Exception e){
            throw new ReagentCatalogueException(e.getMessage());
        }
    }

    public List<JournalEntryResponseDto> getJournalEntryResponseDtos() {
        return journalRepository.findAll().stream().map(Converter::journalToEntryDto).toList();
    }

    public JournalEntryResponseDto addJournalEntry(JournalEntryRequestDto entryDto) {
        return Converter.journalToEntryDto(journalRepository.save(new Journal(entryDto.title(),null,LocalDateTime.now(),LocalDateTime.now())));
    }

    public JournalEntryResponseDto updateJournalEntry(Long id, JournalEntryRequestDto entryDto) {
        Optional<Journal> oldJournalOptional = journalRepository.findById(id);
        if(oldJournalOptional.isEmpty()){
            throw new JournalCatalogueException("Журнала с указанным id не существует");
        }
        Journal oldJournal = oldJournalOptional.get();
        oldJournal.setTitle(entryDto.title());
        oldJournal.setUpdatedAt(LocalDateTime.now());
        journalRepository.save(oldJournal);
        return Converter.journalToEntryDto(oldJournal);
    }
}
