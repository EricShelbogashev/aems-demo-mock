package ru.nsu.ooad.aemsdemo.factory;

import jakarta.annotation.*;
import org.springframework.stereotype.*;
import ru.nsu.ooad.aemsdemo.dto.*;
import ru.nsu.ooad.aemsdemo.factory.exception.catalogue.*;
import ru.nsu.ooad.aemsdemo.factory.exception.management.*;

import java.time.*;
import java.util.*;
import java.util.concurrent.*;

@Component
public class CommonDataHolder {
    private final Map<Long, JournalEntryResponseDto> journalMap = new HashMap<>();
    private final Map<Long, ReagentResponseDto> reagentMap = new HashMap<>();
    private final Map<Long, ReagentUsageResponseDto> reagentUsageMap = new HashMap<>();

    @PostConstruct
    void init() {
        // Добавление записей журналов.
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

        // Добавление химических реактивов.
        String[][] reagents = {
                {"Sodium Chloride", "NaCl"},
                {"Hydrochloric Acid", "HCl"},
                {"Sulfuric Acid", "H2SO4"},
                {"Potassium Permanganate", "KMnO4"},
                {"Ethanol", "C2H5OH"},
                {"Acetone", "C3H6O"},
                {"Benzene", "C6H6"},
                {"Glucose", "C6H12O6"},
                {"Ammonium Nitrate", "NH4NO3"},
                {"Copper Sulfate", "CuSO4"},
                {"Nitric Acid", "HNO3"},
                {"Phosphoric Acid", "H3PO4"},
                {"Magnesium Sulfate", "MgSO4"},
                {"Calcium Carbonate", "CaCO3"},
                {"Silver Nitrate", "AgNO3"},
                {"Acetic Acid", "CH3COOH"},
                {"Sodium Hydroxide", "NaOH"},
                {"Methanol", "CH3OH"},
                {"Ammonia", "NH3"},
                {"Chloroform", "CHCl3"},
                {"Potassium Chloride", "KCl"},
                {"Sodium Bicarbonate", "NaHCO3"},
                {"Zinc Sulfate", "ZnSO4"},
                {"Ferric Chloride", "FeCl3"},
                {"Barium Chloride", "BaCl2"},
                {"Lithium Hydroxide", "LiOH"},
                {"Stannous Chloride", "SnCl2"},
                {"Sodium Phosphate", "Na3PO4"},
                {"Potassium Iodide", "KI"},
                {"Mercuric Chloride", "HgCl2"},
                {"Cadmium Sulfate", "CdSO4"},
                {"Nickel Chlorate", "Ni(ClO3)2"},
                {"Lead Acetate", "Pb(C2H3O2)2"},
                {"Chromium Oxide", "Cr2O3"},
                {"Boric Acid", "H3BO3"},
                {"Sodium Sulfite", "Na2SO3"},
                {"Potassium Dichromate", "K2Cr2O7"},
                {"Copper Nitrate", "Cu(NO3)2"},
                {"Zinc Nitrate", "Zn(NO3)2"},
                {"Aluminum Sulfate", "Al2(SO4)3"},
                {"Sodium Carbonate", "Na2CO3"},
                {"Magnesium Chloride", "MgCl2"},
                {"Calcium Sulfate", "CaSO4"},
                {"Iron(III) Sulfate", "Fe2(SO4)3"},
                {"Tin(II) Chloride", "SnCl2"},
                {"Manganese(II) Sulfate", "MnSO4"},
                {"Cobalt(II) Nitrate", "Co(NO3)2"}
        };


        HazardCategory[] hazardCategories = HazardCategory.values();

        for (long i = 1; i <= 47; i++) {
            int randomIndex = ThreadLocalRandom.current().nextInt(reagents.length);
            int hazardIndex = ThreadLocalRandom.current().nextInt(hazardCategories.length);
            LocalDateTime time = LocalDateTime.now().minusDays(ThreadLocalRandom.current().nextInt(0, 365));

            reagentMap.put(i, new ReagentResponseDto(
                    i,
                    reagents[randomIndex][0],
                    reagents[randomIndex][1],
                    ThreadLocalRandom.current().nextDouble(50.0, 300.0),
                    "Chemical laboratory reagent",
                    hazardCategories[hazardIndex],
                    time,
                    time.plusDays(ThreadLocalRandom.current().nextInt(1, 30))
            ));
        }

        // Добавление статистики использования реактивов.
        UsageReason[] usageReasons = UsageReason.values();
        Unit[] units = Unit.values();

        for (long i = 1; i <= 47; i++) {
            reagentUsageMap.put(i, new ReagentUsageResponseDto(
                    i, // usageId
                    ThreadLocalRandom.current().nextLong(1, 48), // reagentId
                    ThreadLocalRandom.current().nextLong(1, 48), // journalId
                    usageReasons[ThreadLocalRandom.current().nextInt(usageReasons.length)], // reason
                    ThreadLocalRandom.current().nextDouble(1.0, 100.0), // quantity
                    units[ThreadLocalRandom.current().nextInt(units.length)], // unit
                    LocalDateTime.now().minusDays(ThreadLocalRandom.current().nextInt(1, 365)), // updatedAt
                    LocalDateTime.now().minusDays(ThreadLocalRandom.current().nextInt(1, 365)) // createdAt
            ));
        }
    }

    public List<JournalEntryResponseDto> getJournalEntryResponseDtos() {
        return journalMap.values().stream().toList();
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

    public List<ReagentResponseDto> getReagentResponseDtos() {
        return reagentMap.values().stream().toList();
    }

    public ReagentResponseDto addReagent(ReagentRequestDto reagentDto) {
        Long id = reagentMap.keySet().stream().max(Long::compareTo).orElse(0L);
        return reagentMap.put(
                id,
                new ReagentResponseDto(
                        id,
                        reagentDto.name(),
                        reagentDto.latexFormula(),
                        reagentDto.molarWeight(),
                        reagentDto.description(),
                        reagentDto.hazardCategory(),
                        LocalDateTime.now(),
                        LocalDateTime.now()
                )
        );
    }

    public ReagentResponseDto updateReagent(Long id, ReagentRequestDto reagentDto) {
        if (!reagentMap.containsKey(id)) {
            throw new ReagentManagementException("запрашиваемый реагент не существует");
        }
        return reagentMap.computeIfPresent(
                id,
                (key, value) -> new ReagentResponseDto(
                        id,
                        reagentDto.name(),
                        reagentDto.latexFormula(),
                        reagentDto.molarWeight(),
                        reagentDto.description(),
                        reagentDto.hazardCategory(),
                        value.createdAt(),
                        LocalDateTime.now()
                )
        );
    }

    public void deleteReagent(Long id) {
        if (!reagentMap.containsKey(id)) {
            throw new ReagentManagementException("запрашиваемый реагент не существует");
        }
        reagentMap.remove(id);
    }

    public List<ReagentUsageResponseDto> getConsumptionByReagent(Long id) {
        return reagentUsageMap.values().stream().filter(usage -> usage.reagentId().equals(id)).toList();
    }

    public List<ReagentUsageResponseDto> getConsumptions() {
        return reagentUsageMap.values().stream().toList();
    }
}
