package com.enviro.assessement.bulelanigabonewe.Services;

import java.util.Optional;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviro.assessement.bulelanigabonewe.Exceptions.InvalidEntityException;
import com.enviro.assessement.bulelanigabonewe.Exceptions.WasteCategoryNotFoundException;
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
        if(!isInValidCategory(category)){

            return categoriesRepository.save(category);
        } 
        throw new InvalidEntityException("The name/description of waste categories cannot be null");     
    }


    public void deleteCategoryById(Long id) {
        if(categoriesRepository.existsById(id)){
            categoriesRepository.deleteById(id);
        }else{
            throw new WasteCategoryNotFoundException(id);
        }
        
        
    }

    public WasteCategories updateCategory(WasteCategories category){

        if(category.getCategoryId() == null){
            throw new IllegalArgumentException("The category cannot be null");
        }else if(!categoriesRepository.existsById(category.getCategoryId())){
            throw new WasteCategoryNotFoundException(category.getCategoryId());
        }else{
            Optional<WasteCategories> oldCategory = getWasteCategoryById(category.getCategoryId());

            if(!category.getDescription().isEmpty() && 
                !category.getDescription().isBlank() &&
                !category.getDescription().equalsIgnoreCase(oldCategory.get().getDescription()) ){
                    oldCategory.get().setDescription(category.getDescription());
            }

            if(!category.getName().isEmpty() &&
                !category.getName().isBlank() &&
                !oldCategory.get().getName().equals(category.getName())){
                oldCategory.get().setName(null);
            }
            return categoriesRepository.save(oldCategory.get());
        }
    }


    private boolean isInValidCategory(WasteCategories category){
        return category.getDescription().isEmpty() || 
                category.getDescription().isBlank() ||
                category.getName().isEmpty() ||
                category.getName().isBlank(); 
    }

}
