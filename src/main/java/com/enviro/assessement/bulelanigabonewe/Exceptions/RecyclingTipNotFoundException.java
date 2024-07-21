package com.enviro.assessement.bulelanigabonewe.Exceptions;

public class RecyclingTipNotFoundException extends RuntimeException {

    public RecyclingTipNotFoundException(Long id){
        super("Could not find recycling tip with id: " + id);
    }

}
