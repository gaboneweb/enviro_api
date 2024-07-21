package com.enviro.assessement.bulelanigabonewe.Models;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Data
@Entity
@Table(name = "DisposalGuidelines")
public class DisposalGuidelines {
    @Id
    @SequenceGenerator(
        name = "guideline_sequence",
        sequenceName = "guideline_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "guideline_sequence"
    )
    private Long guideline_id;

    private String guideline;

    @ManyToOne
    @JoinColumn(
        name="category_id"
    )
    private WasteCategories category;

    public DisposalGuidelines(){

    }

    public DisposalGuidelines(String guideline){
        this.guideline = guideline;
    }
}
