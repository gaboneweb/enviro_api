package com.enviro.assessement.bulelanigabonewe.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviro.assessement.bulelanigabonewe.Repositories.DisposalGuidelinesRepository;
import com.enviro.assessement.bulelanigabonewe.RequestDTOs.DisposalGuidelinesDTO;
import com.enviro.assessement.bulelanigabonewe.Exceptions.DisposalGuidelineNotFoundException;
import com.enviro.assessement.bulelanigabonewe.Exceptions.InvalidEntityException;
import com.enviro.assessement.bulelanigabonewe.Models.DisposalGuidelines;
import com.enviro.assessement.bulelanigabonewe.Models.WasteCategories;


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


    public DisposalGuidelines updateDisposalGuideline(DisposalGuidelinesDTO guideline){

        if(guideline.getGuidelineId() == null){

            throw new IllegalArgumentException("The disposal guideline id cannot be null");

        }else if(!guidelinesRepository.existsById(guideline.getGuidelineId())){

            throw new DisposalGuidelineNotFoundException(guideline.getGuidelineId());
            
        }else{

             Optional<DisposalGuidelines> currentGuideline =  getGuidelinesById(guideline.getGuidelineId());

            if(!guideline.getGuideline().isBlank() || !guideline.getGuideline().isEmpty() && 
                !guideline.getGuideline().equalsIgnoreCase(currentGuideline.get().getGuideline())){
                    currentGuideline.get().setGuideline(guideline.getGuideline());
            }

            if(guideline.getCategoryId() != null &&
            guideline.getCategoryId() != currentGuideline.get().getCategory().getCategoryId()){
                WasteCategories category = new WasteCategories();
                category.setCategoryId(guideline.getCategoryId());
                currentGuideline.get().setCategory(category);
            }
            return guidelinesRepository.save(currentGuideline.get());
        }
    }


    public DisposalGuidelines addNewDisposalGuideline(DisposalGuidelinesDTO guideline){

        if(guideline.getCategoryId() == null){

            throw new IllegalArgumentException("The category id cannot be null");
            
        }else{
            if(guideline.getGuideline().isEmpty() || guideline.getGuideline().isBlank()){
                throw new InvalidEntityException("The guideline cannot be null/empty");
            }
            DisposalGuidelines newGuideline = new DisposalGuidelines(guideline.getGuideline());
            WasteCategories category = new WasteCategories();
            category.setCategoryId(guideline.getCategoryId());
            newGuideline.setCategory(category);
            return guidelinesRepository.save(newGuideline);
        }
    }
}
