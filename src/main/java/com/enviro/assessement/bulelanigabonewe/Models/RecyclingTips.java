package com.enviro.assessement.bulelanigabonewe.Models;

import lombok.Data;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Data
@Entity
@Table(name="RecyclingTips")
public class RecyclingTips {
    @Id
    @SequenceGenerator(
        name = "recycling_sequence",
        sequenceName = "recycling_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "recycling_sequence"
    )
    private Long tip_id;

    private String tip;

    @ManyToOne
    @JoinColumn(
        name="category_id"
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private WasteCategories category;

    public RecyclingTips(){

    }

    public RecyclingTips(String tip){
        this.tip = tip;
    }
}
