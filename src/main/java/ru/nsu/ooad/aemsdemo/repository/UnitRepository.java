package ru.nsu.ooad.aemsdemo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ooad.aemsdemo.model.UnitModel;

public interface UnitRepository extends JpaRepository<UnitModel,Long> {
    Optional<UnitModel> findByUnit(String unit);
}
