package ru.nsu.ooad.aemsdemo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ooad.aemsdemo.model.UsageReason;

public interface UsageReasonRepository extends JpaRepository<UsageReason,Long> {
    Optional<UsageReason> findByReason(String reason);
}
