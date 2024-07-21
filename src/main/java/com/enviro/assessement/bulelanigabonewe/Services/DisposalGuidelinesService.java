package com.enviro.assessement.bulelanigabonewe.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviro.assessement.bulelanigabonewe.Repositories.DisposalGuidelinesRepository;
import com.enviro.assessement.bulelanigabonewe.Exceptions.DisposalGuidelineNotFoundException;
import com.enviro.assessement.bulelanigabonewe.Models.DisposalGuidelines;


@Service
public class DisposalGuidelinesService {

    private final DisposalGuidelinesRepository guidelinesRepository;


    @Autowired
    public DisposalGuidelinesService(DisposalGuidelinesRepository guidelinesRepository){
        this.guidelinesRepository = guidelinesRepository;
    }


    public List<DisposalGuidelines> getGuidelinesByCategoryId(Long categoryId){
        if(categoryId == null){
            throw new IllegalArgumentException("The category id cannot be null");
        }

        return guidelinesRepository.findGuidelinesByCategoryId(categoryId);
    }


    public Optional<DisposalGuidelines> getGuidelinesById(Long id){
        return guidelinesRepository.findById(id);
    }


    public void deleteGuidelinepById(Long id) {
        if(guidelinesRepository.existsById(id)){
            guidelinesRepository.deleteById(id);
        }else{
            throw new DisposalGuidelineNotFoundException(id);
        }  
    }


    public void deleteGuidelinesCategoryById(Long categoryId){
        if(categoryId == null){
            throw new IllegalArgumentException("The category id cannot be null");
        }
        guidelinesRepository.deleteGuidelinesByCategoryId(categoryId);
    }
}
