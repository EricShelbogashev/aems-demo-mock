package ru.nsu.ooad.aemsdemo.service.utils;

import ru.nsu.ooad.aemsdemo.dto.JournalEntryResponseDto;
import ru.nsu.ooad.aemsdemo.dto.ReagentUsageResponseDto;
import ru.nsu.ooad.aemsdemo.dto.Unit;
import ru.nsu.ooad.aemsdemo.model.HazardCategoryDomain;
import ru.nsu.ooad.aemsdemo.model.Journal;
import ru.nsu.ooad.aemsdemo.model.Reagent;
import ru.nsu.ooad.aemsdemo.dto.HazardCategory;
import ru.nsu.ooad.aemsdemo.dto.ReagentResponseDto;
import ru.nsu.ooad.aemsdemo.model.ReagentUsage;
import ru.nsu.ooad.aemsdemo.model.UnitModel;
import ru.nsu.ooad.aemsdemo.model.UsageReason;

public class Converter {

    public static ReagentResponseDto reagentToDTO(Reagent reagent) {
        return new ReagentResponseDto(reagent.getId(), reagent.getTitle(), reagent.getLatexFormula(),
                reagent.getMolarWeight(), reagent.getDescription(), hazardCategoryToDto(reagent.getHazardCategory()),
                reagent.getCreatedAt(),
                reagent.getUpdatedAt());
    }

    public static HazardCategory hazardCategoryToDto(HazardCategoryDomain hazardCategoryDomain) {
        return HazardCategory.valueOf(hazardCategoryDomain.getCategory());
    }

    public static HazardCategoryDomain hazardCategoryDtoToDomain(HazardCategory hazardCategory) {
        return new HazardCategoryDomain((long) (hazardCategory.ordinal() + 1), hazardCategory.name());
    }

    public static ReagentUsageResponseDto usageToDto(ReagentUsage reagentUsage) {
        return new ReagentUsageResponseDto(reagentUsage.getId(), reagentUsage.getReagent().getId(),
                journalToDto(reagentUsage.getJournal()), usageReasonToDto(reagentUsage.getReason()),
                reagentUsage.getQuantity(), unitToDto(reagentUsage.getUnit()), reagentUsage.getCreatedAt());
    }

    public static JournalEntryResponseDto journalToDto(Journal journal) {
        return new JournalEntryResponseDto(journal.getId(), journal.getTitle(), journal.getCreatedAt(),
                journal.getUpdatedAt());
    }

    public static ru.nsu.ooad.aemsdemo.dto.UsageReason usageReasonToDto(UsageReason reason) {
        return ru.nsu.ooad.aemsdemo.dto.UsageReason.valueOf(reason.getReason());
    }

    public static Unit unitToDto(UnitModel unitModel) {
        return Unit.valueOf(unitModel.getUnit());
    }
}
