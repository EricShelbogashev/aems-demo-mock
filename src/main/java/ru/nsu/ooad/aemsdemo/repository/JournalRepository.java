package ru.nsu.ooad.aemsdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ooad.aemsdemo.model.Journal;

public interface JournalRepository extends JpaRepository<Journal,Long> {
    Journal findByTitle(String title);
}
