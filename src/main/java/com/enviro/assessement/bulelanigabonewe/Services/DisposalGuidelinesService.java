package com.enviro.assessement.bulelanigabonewe.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviro.assessement.bulelanigabonewe.Repositories.DisposalGuidelinesRepository;
import com.enviro.assessement.bulelanigabonewe.Models.DisposalGuidelines;


@Service
public class DisposalGuidelinesService {

    private final DisposalGuidelinesRepository guidelinesRepository;


    @Autowired
    public DisposalGuidelinesService(DisposalGuidelinesRepository guidelinesRepository){
        this.guidelinesRepository = guidelinesRepository;
    }


    public List<DisposalGuidelines> getGuidelinesByCategoryId(Long categoryId){

        return guidelinesRepository.findGuidelinesByCategoryId(categoryId);
    }


    public Optional<DisposalGuidelines> getGuidelinesById(Long id){
        return guidelinesRepository.findById(id);
    }
}
