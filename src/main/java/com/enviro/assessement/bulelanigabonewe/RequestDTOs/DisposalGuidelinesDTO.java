package com.enviro.assessement.bulelanigabonewe.RequestDTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class DisposalGuidelinesDTO {


    private Long guidelineId;

    @NotBlank(message = "The guiline cannot be null/empty")
    private String guideline;

    @NotNull(message = "category id cannot be null")
    private Long categoryId;

    public DisposalGuidelinesDTO(){

    }

    public DisposalGuidelinesDTO(Long guidelineId,String guideline, Long categoryId){
        this.guidelineId = guidelineId;
        this.guideline = guideline;
        this.categoryId = categoryId;
    }
}
