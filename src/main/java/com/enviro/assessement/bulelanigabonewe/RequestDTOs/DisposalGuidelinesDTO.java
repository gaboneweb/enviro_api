package com.enviro.assessement.bulelanigabonewe.RequestDTOs;

import lombok.Data;


@Data
public class DisposalGuidelinesDTO {

    private Long guidelineId;

    private String guideline;

    private Long categoryId;

    public DisposalGuidelinesDTO(){

    }

    public DisposalGuidelinesDTO(Long guidelineId,String guideline, Long categoryId){
        this.guidelineId = guidelineId;
        this.guideline = guideline;
        this.categoryId = categoryId;
    }
}
