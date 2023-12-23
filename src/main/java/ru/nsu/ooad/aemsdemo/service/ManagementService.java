package ru.nsu.ooad.aemsdemo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import ru.nsu.ooad.aemsdemo.dto.ReagentRequestDto;
import ru.nsu.ooad.aemsdemo.dto.ReagentResponseDto;
import ru.nsu.ooad.aemsdemo.dto.ReagentUsageResponseDto;
import ru.nsu.ooad.aemsdemo.factory.exception.management.ReagentManagementException;
import ru.nsu.ooad.aemsdemo.model.Reagent;
import ru.nsu.ooad.aemsdemo.repository.ReagentRepository;
import ru.nsu.ooad.aemsdemo.repository.ReagentUsageRepository;
import ru.nsu.ooad.aemsdemo.service.utils.Converter;

@Service
public class ManagementService {
    private final ReagentUsageRepository reagentUsageRepository;
    private final ReagentRepository reagentRepository;

    public ManagementService(ReagentUsageRepository reagentUsageRepository, ReagentRepository reagentRepository) {
        this.reagentUsageRepository = reagentUsageRepository;
        this.reagentRepository = reagentRepository;
    }


    public ReagentResponseDto updateReagent(Long id, ReagentRequestDto reagentDto) {
        Optional<Reagent> optionalReagent = reagentRepository.findById(id);
        if (optionalReagent.isEmpty()){
            throw new ReagentManagementException("Реагента с указанный id не существует");
        }
        Reagent reagent = optionalReagent.get();
        reagent.setTitle(reagentDto.name());
        reagent.setLatexFormula(reagentDto.latexFormula());
        reagent.setMolarWeight(reagentDto.molarWeight());
        reagent.setDescription(reagent.getDescription());
        reagent.setHazardCategory(Converter.hazardCategoryDtoToDomain(reagentDto.hazardCategory()));
        return Converter.reagentToDTO(reagent);
    }

    public void deleteReagent(Long id) {
        reagentRepository.deleteById(id);
    }

    public List<ReagentUsageResponseDto> getConsumptionByReagent(Long id) {
       return reagentUsageRepository.findAllByReagentId(id).stream().map(Converter::usageToDto).toList();
    }
}
