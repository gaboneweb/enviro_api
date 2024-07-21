package com.enviro.assessement.bulelanigabonewe.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enviro.assessement.bulelanigabonewe.Services.DisposalGuidelinesService;
import com.enviro.assessement.bulelanigabonewe.Exceptions.DisposalGuidelineNotFoundException;
import com.enviro.assessement.bulelanigabonewe.Models.DisposalGuidelines;

@RestController
@RequestMapping("/guidelines")
public class DisposalGuidelinesController {

    private final DisposalGuidelinesService disposalGuidelinesService;

    @Autowired
    public DisposalGuidelinesController(DisposalGuidelinesService disposalGuidelinesService){
        this.disposalGuidelinesService = disposalGuidelinesService;
    }


    @GetMapping("/{id}")
    public DisposalGuidelines getGuidelinesById(@PathVariable Long id){
        return disposalGuidelinesService.getGuidelinesById(id)
                .orElseThrow( () -> new DisposalGuidelineNotFoundException(id));
    }

    @GetMapping("/category/{categoryId}")
    public List<DisposalGuidelines> getGuidelinesByCategoryId(@PathVariable Long categoryId){
        return disposalGuidelinesService.getGuidelinesByCategoryId(categoryId);
    }

}
