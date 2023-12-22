package ru.nsu.ooad.aemsdemo.service;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.nsu.ooad.aemsdemo.domai.Reagent;
import ru.nsu.ooad.aemsdemo.dto.ReagentRequestDto;
import ru.nsu.ooad.aemsdemo.dto.ReagentResponseDto;
import ru.nsu.ooad.aemsdemo.repository.ReagentRepository;

@Service
public class ReagentService {

    private final ReagentRepository reagentRepository;

    public ReagentService(ReagentRepository reagentRepository) {
        this.reagentRepository = reagentRepository;
    }

    public List<ReagentResponseDto> getReagentResponseDtos() {
        return reagentRepository.findAll();
    }

    public ReagentResponseDto addReagent(ReagentRequestDto reagentDto) {
    }

    private ReagentResponseDto convertDomainToDTO(Reagent reagent) {
        return new ReagentResponseDto(reagent.getId(), reagent.getTitle(), reagent.getLatexFormula(),
                reagent.getMolarWeight(), reagent.getDescription(), reagent.getHazardCategory(), reagent.getCreatedAt(),
                reagent.getUpdatedAt());
    }
}
