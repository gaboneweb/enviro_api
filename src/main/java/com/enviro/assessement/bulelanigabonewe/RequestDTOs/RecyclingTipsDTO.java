package com.enviro.assessement.bulelanigabonewe.RequestDTOs;

import lombok.Data;

@Data

public class RecyclingTipsDTO {

    private Long tipId;

    private String tip;

    private Long categoryId;

    public RecyclingTipsDTO(){

    }

    public RecyclingTipsDTO(Long tipId, String tip, Long categoryId){
        this.tipId = tipId;
        this.tip = tip;
        this.categoryId = categoryId;
    }
}
