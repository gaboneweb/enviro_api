package com.enviro.assessement.bulelanigabonewe.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.enviro.assessement.bulelanigabonewe.Services.RecyclingTipsService;

@RestController
public class RecyclingTipsController {

    private final RecyclingTipsService recyclingTipsService;


    @Autowired
    public RecyclingTipsController(RecyclingTipsService recyclingTipsService){
        this.recyclingTipsService = recyclingTipsService;
    }

}
