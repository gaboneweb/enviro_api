package com.enviro.assessement.bulelanigabonewe.Services;

import java.util.Optional;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviro.assessement.bulelanigabonewe.Models.WasteCategories;
import com.enviro.assessement.bulelanigabonewe.Repositories.WasteCategoriesRepository;

@Service
public class WasteCategoryService {

    private final WasteCategoriesRepository categoriesRepository;

    @Autowired
    public  WasteCategoryService(WasteCategoriesRepository categoriesRepository){
        this.categoriesRepository = categoriesRepository;
    }


    public Optional<WasteCategories> getWasteCategoryById(Long id){
        return categoriesRepository.findById(id);
    }

    public List<WasteCategories> getWasteCategories(){
        return categoriesRepository.findAll();
    }


    public WasteCategories addNewCategory(WasteCategories category) {
        return categoriesRepository.save(category);
    }

}
