package com.enviro.assessement.bulelanigabonewe.Models;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Data
@Entity
@Table(name = "WasteCategories")
public class WasteCategories {
    @Id
    @SequenceGenerator(
        name = "category_sequence",
        sequenceName = "category_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "category_sequence"
    )
    private Long category_id;

    private String name;

    private String description;

    public WasteCategories(){

    }

    public WasteCategories(String name,String description){
        this.name = name;
        this.description = description;
    }
}
