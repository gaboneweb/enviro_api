package com.enviro.assessement.bulelanigabonewe.Exceptions;

public class WasteCategoryNotFoundException extends RuntimeException {

    public WasteCategoryNotFoundException(Long id){
        super("Could not find waste category with id : " + id);
    }


}
