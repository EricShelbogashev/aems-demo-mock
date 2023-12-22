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
@Table(name = "reagent")
public class Reagent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "latex_formula")
    private String latexFormula;

    @Column(name = "molar_weight", nullable = false)
    private Double molarWeight;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "hazard_category", nullable = false)
    private Long hazardCategory;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLatexFormula() {
        return latexFormula;
    }

    public void setLatexFormula(String latexFormula) {
        this.latexFormula = latexFormula;
    }

    public Double getMolarWeight() {
        return molarWeight;
    }

    public void setMolarWeight(Double molarWeight) {
        this.molarWeight = molarWeight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getHazardCategory() {
        return hazardCategory;
    }

    public void setHazardCategory(Long hazardCategory) {
        this.hazardCategory = hazardCategory;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
