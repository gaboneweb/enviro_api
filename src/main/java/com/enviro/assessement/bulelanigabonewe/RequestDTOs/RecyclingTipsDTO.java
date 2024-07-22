package com.enviro.assessement.bulelanigabonewe.RequestDTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data

public class RecyclingTipsDTO {

    private Long tipId;

    @NotBlank(message = "The recycling tip cannot null/empty")
    private String tip;

    @NotNull(message = "category id cannot be null")
    private Long categoryId;

    public RecyclingTipsDTO(){

    }

    public RecyclingTipsDTO(Long tipId, String tip, Long categoryId){
        this.tipId = tipId;
        this.tip = tip;
        this.categoryId = categoryId;
    }
}
