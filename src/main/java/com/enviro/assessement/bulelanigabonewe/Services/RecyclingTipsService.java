package com.enviro.assessement.bulelanigabonewe.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviro.assessement.bulelanigabonewe.Exceptions.RecyclingTipNotFoundException;
import com.enviro.assessement.bulelanigabonewe.Models.RecyclingTips;
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


}
