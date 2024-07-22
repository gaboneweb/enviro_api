package com.enviro.assessement.bulelanigabonewe.RequestDTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class WasteCategoriesDTO {

    private Long categoryId;
    
    @NotBlank(message = "Category name cannot be null/empty")
    private String name;

    @NotBlank(message = "Category description cannot be null/empty")
    private String description;

    public WasteCategoriesDTO(){

    }

    public WasteCategoriesDTO(Long categoryId ,String name,String description){
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
    }
}
