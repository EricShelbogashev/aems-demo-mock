package ru.nsu.ooad.aemsdemo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ooad.aemsdemo.model.Journal;
import ru.nsu.ooad.aemsdemo.model.ReagentUsage;

public interface ReagentUsageRepository extends JpaRepository<ReagentUsage, Long> {
    List<ReagentUsage> findAllByReagentId(Long reagent_id);
    List<ReagentUsage> findAllByJournal(Journal journal);
}
