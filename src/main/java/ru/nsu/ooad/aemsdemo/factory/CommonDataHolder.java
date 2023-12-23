package ru.nsu.ooad.aemsdemo.factory;

import jakarta.annotation.*;
import org.springframework.stereotype.*;
import ru.nsu.ooad.aemsdemo.dto.*;
import ru.nsu.ooad.aemsdemo.factory.exception.catalogue.*;
import ru.nsu.ooad.aemsdemo.factory.exception.management.*;
import ru.nsu.ooad.aemsdemo.factory.exception.studio.*;

import java.time.*;
import java.util.*;
import java.util.concurrent.*;

public class CommonDataHolder {
    private final Map<Long, JournalEntryResponseDto> journalMap = new HashMap<>();
    private final Map<Long, ReagentResponseDto> reagentMap = new HashMap<>();
    private final Map<Long, ReagentUsageResponseDto> reagentUsageMap = new HashMap<>();
    private final Map<Long, JournalContentResponseDto> journalContentMap = new HashMap<>();

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
                {"Sulfuric Acid", "H_{2}SO_{4}"},
                {"Potassium Permanganate", "KMnO_{4}"},
                {"Ethanol", "C_{2}H_{5}OH"},
                {"Acetone", "C_{3}H_{6}O"},
                {"Benzene", "C_{6}H_{6}"},
                {"Glucose", "C_{6}H_{12}O_{6}"},
                {"Ammonium Nitrate", "NH_{4}NO_{3}"},
                {"Copper Sulfate", "CuSO_{4}"},
                {"Nitric Acid", "HNO_{3}"},
                {"Phosphoric Acid", "H_{3}PO_{4}"},
                {"Magnesium Sulfate", "MgSO_{4}"},
                {"Calcium Carbonate", "CaCO_{3}"},
                {"Silver Nitrate", "AgNO_{3}"},
                {"Acetic Acid", "CH_{3}COOH"},
                {"Sodium Hydroxide", "NaOH"},
                {"Methanol", "CH_{3}OH"},
                {"Ammonia", "NH_{3}"},
                {"Chloroform", "CHCl_{3}"},
                {"Potassium Chloride", "KCl"},
                {"Sodium Bicarbonate", "NaHCO_{3}"},
                {"Zinc Sulfate", "ZnSO_{4}"},
                {"Ferric Chloride", "FeCl_{3}"},
                {"Barium Chloride", "BaCl_{2}"},
                {"Lithium Hydroxide", "LiOH"},
                {"Stannous Chloride", "SnCl_{2}"},
                {"Sodium Phosphate", "Na_{3}PO_{4}"},
                {"Potassium Iodide", "KI"},
                {"Mercuric Chloride", "HgCl_{2}"},
                {"Cadmium Sulfate", "CdSO_{4}"},
                {"Nickel Chlorate", "Ni(ClO_{3})_{2}"},
                {"Lead Acetate", "Pb(C_{2}H_{3}O_{2})_{2}"},
                {"Chromium Oxide", "Cr_{2}O_{3}"},
                {"Boric Acid", "H_{3}BO_{3}"},
                {"Sodium Sulfite", "Na_{2}SO_{3}"},
                {"Potassium Dichromate", "K_{2}Cr_{2}O_{7}"},
                {"Copper Nitrate", "Cu(NO_{3})_{2}"},
                {"Zinc Nitrate", "Zn(NO_{3})_{2}"},
                {"Aluminum Sulfate", "Al_{2}(SO_{4})_{3}"},
                {"Sodium Carbonate", "Na_{2}CO_{3}"},
                {"Magnesium Chloride", "MgCl_{2}"},
                {"Calcium Sulfate", "CaSO_{4}"},
                {"Iron(III) Sulfate", "Fe_{2}(SO_{4})_{3}"},
                {"Tin(II) Chloride", "SnCl_{2}"},
                {"Manganese(II) Sulfate", "MnSO_{4}"},
                {"Cobalt(II) Nitrate", "Co(NO_{3})_{2}"}
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
                    journalMap.get(ThreadLocalRandom.current().nextLong(1, 47)), // journalId
                    usageReasons[ThreadLocalRandom.current().nextInt(usageReasons.length)], // reason
                    ThreadLocalRandom.current().nextDouble(1.0, 100.0), // quantity
                    units[ThreadLocalRandom.current().nextInt(units.length)], // unit
                    LocalDateTime.now().minusDays(ThreadLocalRandom.current().nextInt(1, 365)) // createdAt
            ));
        }

        // Добавление контента лабораторных журналов.
        for (long i = 1; i <= 47; i++) {
            List<ReagentUsageResponseDto> usages = getRandomUsages();
            journalContentMap.put(i, new JournalContentResponseDto(
                    i,
                    "Journal Title " + i,
                    new JournalTextResponseDto("Journal text content " + i),
                    usages
            ));
        }

    }

    private List<ReagentUsageResponseDto> getRandomUsages() {
        List<ReagentUsageResponseDto> usages = new ArrayList<>();
        int usageCount = ThreadLocalRandom.current().nextInt(1, 5); // От 1 до 4 использований на журнал

        for (int i = 0; i < usageCount; i++) {
            long randomId = ThreadLocalRandom.current().nextLong(1, reagentUsageMap.size());
            usages.add(reagentUsageMap.get(randomId));
        }

        return usages;
    }

    public List<JournalEntryResponseDto> getJournalEntryResponseDtos() {
        return journalMap.values().stream().toList();
    }


    public JournalEntryResponseDto addJournalEntry(JournalEntryRequestDto entryDto) {
        Long id = journalMap.keySet().stream().max(Long::compareTo).orElse(0L) + 1;
        JournalEntryResponseDto responseDto = new JournalEntryResponseDto(
                id,
                entryDto.title(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
        journalMap.put(
                id,
                responseDto
        );
        return responseDto;
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
        Long id = reagentMap.keySet().stream().max(Long::compareTo).orElse(0L) + 1;
        ReagentResponseDto responseDto = new ReagentResponseDto(
                id,
                reagentDto.name(),
                reagentDto.latexFormula(),
                reagentDto.molarWeight(),
                reagentDto.description(),
                reagentDto.hazardCategory(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
        reagentMap.put(
                id,
                responseDto
        );
        return responseDto;
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
        reagentUsageMap.values().stream()
                .map(ReagentUsageResponseDto::reagentId)
                .filter(identifier -> identifier.equals(id))
                .forEach(reagentMap::remove);
    }

    public List<ReagentUsageResponseDto> getConsumptionByReagent(Long id) {
        return reagentUsageMap.values().stream().filter(usage -> usage.reagentId().equals(id)).toList();
    }

    public List<ReagentUsageResponseDto> getConsumptions() {
        return reagentUsageMap.values().stream().toList();
    }

    public JournalContentResponseDto getJournalContent(Long journalId) {
        if (!reagentMap.containsKey(journalId)) {
            throw new JournalContentException("запрашиваемый журнал не существует, невозможно найти содержимое");
        }
        return journalContentMap.get(journalId);
    }

    public JournalTextResponseDto updateText(Long journalId, JournalTextRequestDto textDto) {
        if (!journalContentMap.containsKey(journalId)) {
            throw new JournalContentException("запрашиваемый журнал не существует, невозможно найти текст");
        }

        JournalContentResponseDto contentResponseDto = journalContentMap.computeIfPresent(
                journalId,
                (key, value) -> {
                    var text = value.journalTextDto();
                    text = new JournalTextResponseDto(textDto.text());
                    return new JournalContentResponseDto(
                            value.id(),
                            value.title(),
                            text,
                            value.usages()
                    );
                }
        );

        return Objects.requireNonNull(contentResponseDto).journalTextDto();
    }

    public ReagentUsageResponseDto addUsage(Long journalId, ReagentUsageRequestDto usageDto) {
        if (!journalContentMap.containsKey(journalId)) {
            throw new JournalContentException("запрашиваемый журнал не существует, невозможно найти использования");
        }
        Long id = reagentUsageMap.keySet().stream().max(Long::compareTo).orElse(0L) + 1;

        ReagentUsageResponseDto usageResponseDto = new ReagentUsageResponseDto(
                id,
                usageDto.reagentId(),
                journalMap.get(journalId),
                usageDto.reason(),
                usageDto.quantity(),
                usageDto.unit(),
                LocalDateTime.now()
        );

        journalContentMap.computeIfPresent(
                journalId,
                (key, value) -> {
                    var usages = value.usages();
                    usages.add(usageResponseDto);
                    return new JournalContentResponseDto(
                            value.id(),
                            value.title(),
                            value.journalTextDto(),
                            usages
                    );
                }
        );

        return usageResponseDto;
    }

    public void deleteUsage(Long journalId, Long usageId) {
        if (!journalContentMap.containsKey(journalId)) {
            throw new JournalContentException("запрашиваемый журнал не существует, невозможно найти использования");
        }

        journalContentMap.computeIfPresent(
                journalId,
                (key, value) -> {
                    var usages = value.usages();
                    Optional<ReagentUsageResponseDto> any = usages.stream().filter(t -> t.usageId().equals(usageId)).findAny();
                    any.ifPresent(usages::remove);
                    return new JournalContentResponseDto(
                            value.id(),
                            value.title(),
                            value.journalTextDto(),
                            usages
                    );
                }
        );

    }
}
