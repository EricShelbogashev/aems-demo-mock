package ru.nsu.ooad.aemsdemo.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import ru.nsu.ooad.aemsdemo.model.Reagent;
import ru.nsu.ooad.aemsdemo.dto.ReagentRequestDto;
import ru.nsu.ooad.aemsdemo.dto.ReagentResponseDto;
import ru.nsu.ooad.aemsdemo.factory.exception.catalogue.ReagentCatalogueException;
import ru.nsu.ooad.aemsdemo.repository.ReagentRepository;
import ru.nsu.ooad.aemsdemo.service.utils.Converter;

@Service
public class CatalogueService {

    private final ReagentRepository reagentRepository;

    public CatalogueService(ReagentRepository reagentRepository) {
        this.reagentRepository = reagentRepository;
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
        Reagent oldReagent = reagentRepository.findByTitle(reagentDto.name());
        if (oldReagent != null) {
            throw new ReagentCatalogueException("Реагент с таким именем уже существует");
        }
        Reagent reagent = reagentRepository.save(
                new Reagent(reagentDto.name(), reagentDto.latexFormula(), reagentDto.molarWeight(),
                        reagentDto.description(), Converter.hazardCategoryDtoToDomain(reagentDto.hazardCategory()),
                        LocalDateTime.now(), LocalDateTime.now()));
        return Converter.reagentToDTO(reagent);
    }

}
