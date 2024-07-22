package com.enviro.assessement.bulelanigabonewe.RequestDTOs;

import lombok.Data;


@Data
public class WasteCategoriesDTO {

    private Long categoryId;
    
    private String name;

    private String description;

    public WasteCategoriesDTO(){

    }

    public WasteCategoriesDTO(Long categoryId ,String name,String description){
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
    }
}
