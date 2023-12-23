package ru.nsu.ooad.aemsdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "reagent_usage")
public class ReagentUsage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "reagent_id")
    private Reagent reagent;

    @OneToOne
    @JoinColumn(name = "journal_id")
    private Journal journal;

    @OneToOne
    @JoinColumn(name = "reason")
    private UsageReason reason;

    @Column(name = "quantity", nullable = false)
    private Double quantity;

    @OneToOne
    @JoinColumn(name = "unit")
    private UnitModel unit;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public ReagentUsage(Reagent reagent, Journal journal, UsageReason reason, Double quantity, UnitModel unit) {
        this.reagent = reagent;
        this.journal = journal;
        this.reason = reason;
        this.quantity = quantity;
        this.unit = unit;
        this.createdAt = LocalDateTime.now();
    }

    public ReagentUsage() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Reagent getReagent() {
        return reagent;
    }

    public void setReagent(Reagent reagent) {
        this.reagent = reagent;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    public UsageReason getReason() {
        return reason;
    }

    public void setReason(UsageReason reason) {
        this.reason = reason;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public UnitModel getUnit() {
        return unit;
    }

    public void setUnit(UnitModel unit) {
        this.unit = unit;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
