package ru.nsu.ooad.aemsdemo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ru.nsu.ooad.aemsdemo.domai.Reagent;
import ru.nsu.ooad.aemsdemo.dto.ReagentRequestDto;
import ru.nsu.ooad.aemsdemo.dto.ReagentResponseDto;
import ru.nsu.ooad.aemsdemo.repository.ReagentRepository;
import ru.nsu.ooad.aemsdemo.service.utils.Converter;

@Service
public class ReagentService {

    private final ReagentRepository reagentRepository;

    public ReagentService(ReagentRepository reagentRepository) {
        this.reagentRepository = reagentRepository;
    }

    public List<ReagentResponseDto> getReagentResponseDtos() {
        List<Reagent> all = reagentRepository.findAll();
        System.out.println(all);
        return all.stream().peek(System.out::println).map(Converter::reagentToDTO).toList();
    }

    public ReagentResponseDto addReagent(ReagentRequestDto reagentDto) {
        Reagent oldReagent = reagentRepository.findByTitle(reagentDto.name());
        if (oldReagent == null) {
            reagentRepository.save(new Reagent(reagentDto.name(), reagentDto.latexFormula(), reagentDto.molarWeight(),
                    reagentDto.description(), Converter.hazardCategoryDtoToDomain(reagentDto.hazardCategory())));
        }
        return null;
    }

}
