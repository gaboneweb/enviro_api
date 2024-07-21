package com.enviro.assessement.bulelanigabonewe.Exceptions;

public class DisposalGuidelineNotFoundException extends RuntimeException {

    public DisposalGuidelineNotFoundException(Long id){
        super("Could not find disposal guideline with id : " + id);
    }

}
