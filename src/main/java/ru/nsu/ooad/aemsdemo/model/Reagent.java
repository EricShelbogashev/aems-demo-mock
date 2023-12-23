package ru.nsu.ooad.aemsdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

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

    @OneToOne
    @JoinColumn(name = "hazard_category")
    private HazardCategoryDomain hazardCategoryDomain;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Reagent(String title, String latexFormula, Double molarWeight, String description,
            HazardCategoryDomain hazardCategoryDomain, LocalDateTime createdAt, LocalDateTime updatedAt) {

        this.title = title;
        this.latexFormula = latexFormula;
        this.molarWeight = molarWeight;
        this.description = description;
        this.hazardCategoryDomain = hazardCategoryDomain;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Reagent() {

    }

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

    public HazardCategoryDomain getHazardCategory() {
        return hazardCategoryDomain;
    }

    public void setHazardCategory(HazardCategoryDomain hazardCategory) {
        this.hazardCategoryDomain = hazardCategory;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
