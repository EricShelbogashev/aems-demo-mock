package ru.nsu.ooad.aemsdemo.domai;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "reagent_usage")
public class ReagentUsage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reagent_id", nullable = false)
    private Long reagentId;

    @Column(name = "journal_id", nullable = false)
    private Long journalId;

    @Column(name = "reason", nullable = false)
    private Long reason;

    @Column(name = "quantity", nullable = false)
    private BigDecimal quantity;

    @Column(name = "unit", nullable = false)
    private Long unit;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

}
