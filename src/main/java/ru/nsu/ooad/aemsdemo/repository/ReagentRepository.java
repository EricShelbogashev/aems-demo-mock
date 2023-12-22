package ru.nsu.ooad.aemsdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nsu.ooad.aemsdemo.domai.Reagent;
import ru.nsu.ooad.aemsdemo.dto.ReagentResponseDto;

@Repository
public interface ReagentRepository extends JpaRepository<Reagent,Long> {

    Reagent findByTitle(String title);
}
