package ru.nsu.ooad.aemsdemo.service.utils;

import ru.nsu.ooad.aemsdemo.domai.HazardCategoryDomain;
import ru.nsu.ooad.aemsdemo.domai.Reagent;
import ru.nsu.ooad.aemsdemo.dto.HazardCategory;
import ru.nsu.ooad.aemsdemo.dto.ReagentResponseDto;

public class Converter {
    public static ReagentResponseDto reagentToDTO(Reagent reagent) {
        return new ReagentResponseDto(reagent.getId(), reagent.getTitle(), reagent.getLatexFormula(),
                reagent.getMolarWeight(), reagent.getDescription(), hazardCategoryToDto(reagent.getHazardCategory()), reagent.getCreatedAt(),
                reagent.getUpdatedAt());
    }

    public static HazardCategory hazardCategoryToDto(HazardCategoryDomain hazardCategoryDomain){
        return HazardCategory.valueOf(hazardCategoryDomain.getCategory());
    }

    public static HazardCategoryDomain hazardCategoryDtoToDomain(HazardCategory hazardCategory){
        return new HazardCategoryDomain((long) (hazardCategory.ordinal()+1),hazardCategory.name());
    }
}
