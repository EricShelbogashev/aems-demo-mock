package ru.nsu.ooad.aemsdemo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import ru.nsu.ooad.aemsdemo.dto.JournalContentResponseDto;
import ru.nsu.ooad.aemsdemo.dto.JournalTextRequestDto;
import ru.nsu.ooad.aemsdemo.dto.JournalTextResponseDto;
import ru.nsu.ooad.aemsdemo.dto.ReagentUsageRequestDto;
import ru.nsu.ooad.aemsdemo.dto.ReagentUsageResponseDto;
import ru.nsu.ooad.aemsdemo.factory.exception.studio.JournalContentException;
import ru.nsu.ooad.aemsdemo.factory.exception.studio.ReagentUsageException;
import ru.nsu.ooad.aemsdemo.model.Journal;
import ru.nsu.ooad.aemsdemo.model.Reagent;
import ru.nsu.ooad.aemsdemo.model.ReagentUsage;
import ru.nsu.ooad.aemsdemo.model.UnitModel;
import ru.nsu.ooad.aemsdemo.model.UsageReason;
import ru.nsu.ooad.aemsdemo.repository.JournalRepository;
import ru.nsu.ooad.aemsdemo.repository.ReagentRepository;
import ru.nsu.ooad.aemsdemo.repository.ReagentUsageRepository;
import ru.nsu.ooad.aemsdemo.repository.UnitRepository;
import ru.nsu.ooad.aemsdemo.repository.UsageReasonRepository;
import ru.nsu.ooad.aemsdemo.service.utils.Converter;

@Service
public class StudioService {

    private final JournalRepository journalRepository;
    private final ReagentUsageRepository reagentUsageRepository;
    private final ReagentRepository reagentRepository;

    private final UsageReasonRepository usageReasonRepository;

    private final UnitRepository unitRepository;

    public StudioService(JournalRepository journalRepository, ReagentUsageRepository reagentUsageRepository,
            ReagentRepository reagentRepository, UsageReasonRepository usageReasonRepository,
            UnitRepository unitRepository) {
        this.journalRepository = journalRepository;
        this.reagentUsageRepository = reagentUsageRepository;
        this.reagentRepository = reagentRepository;
        this.usageReasonRepository = usageReasonRepository;
        this.unitRepository = unitRepository;
    }


    public void deleteJournalEntry(Long journalId) {
        journalRepository.deleteById(journalId);
    }

    public JournalContentResponseDto getJournalContent(Long journalId) {
        Optional<Journal> journalOptional = journalRepository.findById(journalId);
        if (journalOptional.isEmpty()) {
            throw new JournalContentException("Журнала с указанным id не существует");
        }
        Journal journal = journalOptional.get();
        List<ReagentUsage> reagentUsageList = reagentUsageRepository.findAllByJournal(journal);
        return Converter.journalToContentDto(journal, reagentUsageList);
    }

    public JournalTextResponseDto updateText(Long journalId, JournalTextRequestDto textDto) {
        Optional<Journal> journalOptional = journalRepository.findById(journalId);
        if (journalOptional.isEmpty()) {
            throw new JournalContentException("Журнал у указанным id не существует");
        }
        Journal journal = journalOptional.get();
        journal.setText(textDto.text());
        journal.setUpdatedAt(LocalDateTime.now());
        return new JournalTextResponseDto(journalRepository.save(journal).getText());
    }

    public ReagentUsageResponseDto addUsage(Long journalId, ReagentUsageRequestDto usageDto) {
        Optional<Reagent> reagentOptional = reagentRepository.findById(usageDto.reagentId());
        Optional<Journal> journalOptional = journalRepository.findById(usageDto.journalId());
        Optional<UsageReason> optionalUsageReason = usageReasonRepository.findByReason(usageDto.reason().name());
        Optional<UnitModel> unitModelOptional = unitRepository.findByUnit(usageDto.unit().name());

        if (reagentOptional.isEmpty()) {
            throw new ReagentUsageException("Реагента с указанным id не существует");
        }
        if (journalOptional.isEmpty()) {
            throw new ReagentUsageException("Журнала с указанным id не существует");
        }
        if (optionalUsageReason.isEmpty()){
            throw new ReagentUsageException("Указанной причины не существует");
        }
        if (unitModelOptional.isEmpty()){
            throw new ReagentUsageException("Указанной единицы измерения не существует");
        }
        ReagentUsage reagentUsage = new ReagentUsage(reagentOptional.get(),journalOptional.get(),optionalUsageReason.get(),usageDto.quantity(),unitModelOptional.get());
        return Converter.reagentUsageToDto(reagentUsageRepository.save(reagentUsage));
    }

    public void deleteUsage(Long journalId, Long usageId) {
        reagentUsageRepository.deleteById(usageId);
    }
}
