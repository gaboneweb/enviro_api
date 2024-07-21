package com.enviro.assessement.bulelanigabonewe.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviro.assessement.bulelanigabonewe.Exceptions.InvalidEntityException;
import com.enviro.assessement.bulelanigabonewe.Exceptions.RecyclingTipNotFoundException;
import com.enviro.assessement.bulelanigabonewe.Models.RecyclingTips;
import com.enviro.assessement.bulelanigabonewe.Models.WasteCategories;
import com.enviro.assessement.bulelanigabonewe.Repositories.RecyclingTipsRepository;

@Service
public class RecyclingTipsService {

    private final RecyclingTipsRepository recyclingTipsRepository;

    @Autowired
    public RecyclingTipsService(RecyclingTipsRepository recyclingTipsRepository){
        this.recyclingTipsRepository = recyclingTipsRepository;
    }

    public Optional<RecyclingTips> getRecyclingTipById(Long id){
        return recyclingTipsRepository.findById(id);
    }

    public List<RecyclingTips> getRecyclingTipByCategoryId(Long categoryId) {
        if(categoryId == null){
            throw new IllegalArgumentException("The category id cannot be null");
        }
        return recyclingTipsRepository.findRecyclingTipsByCategoryId(categoryId);
    }

    public void deleteTipById(Long id) {
        if(recyclingTipsRepository.existsById(id)){
            recyclingTipsRepository.deleteById(id);
        }else{
            throw new RecyclingTipNotFoundException(id);
        }  
    }


    public void deleteTipsCategoryById(Long categoryId){
        if(categoryId == null){
            throw new IllegalArgumentException("The category id cannot be null");
        }

        recyclingTipsRepository.deleteRecyclingTipsByCategoryId(categoryId);
    }

    public RecyclingTips updateRecyclingTip(RecyclingTips tip){

        if(tip.getTipId() == null){
            throw new IllegalArgumentException("The recyling tip id cannot be null");
        }else if(!recyclingTipsRepository.existsById(tip.getTipId())){
            throw new RecyclingTipNotFoundException(tip.getTipId());
        }
        else{
            Optional<RecyclingTips> currentTip =  getRecyclingTipById(tip.getTipId());

            if(!tip.getTip().isBlank() || !tip.getTip().isEmpty() && 
                !tip.getTip().equalsIgnoreCase(currentTip.get().getTip())){
                    currentTip.get().setTip(tip.getTip());
            }

            if(tip.getCategory().getCategoryId() != null &&
            tip.getCategory().getCategoryId() != currentTip.get().getCategory().getCategoryId()){
                WasteCategories category = new WasteCategories();
                category.setCategoryId(tip.getCategory().getCategoryId());
                currentTip.get().setCategory(category);
            }

            return recyclingTipsRepository.save(currentTip.get());
        }
    }


    public RecyclingTips addNewRecyclingTip(RecyclingTips tip){

       if(tip.getCategory() != null && tip.getCategory().getCategoryId() == null){

            throw new IllegalArgumentException("The category id cannot be null");
        }
        else{
            if(tip.getTip().isEmpty() || tip.getTip().isBlank()){
                throw new InvalidEntityException("The tip cannot be null/empty");
            }
            return recyclingTipsRepository.save(tip);
        }
    }



}
