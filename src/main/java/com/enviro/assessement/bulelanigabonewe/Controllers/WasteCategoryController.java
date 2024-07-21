package com.enviro.assessement.bulelanigabonewe.Controllers;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enviro.assessement.bulelanigabonewe.Exceptions.WasteCategoryNotFoundException;
import com.enviro.assessement.bulelanigabonewe.Models.WasteCategories;
import com.enviro.assessement.bulelanigabonewe.Services.WasteCategoryService;

@RestController
@RequestMapping("/waste-categories")
public class WasteCategoryController {
    private final WasteCategoryService wasteCategoryService;

    public WasteCategoryController(WasteCategoryService wasteCategoryService){
        this.wasteCategoryService = wasteCategoryService;
    }


    @GetMapping("/{id}")
    public WasteCategories getCategotiesById(@PathVariable Long id){
        return wasteCategoryService.getWasteCategoryById(id)
        .orElseThrow( ()-> new WasteCategoryNotFoundException(id));
    }

    @GetMapping("/")
    public List<WasteCategories> getAllWasteCategories(){
        return wasteCategoryService.getWasteCategories();
    }

    @PostMapping("/new")
    public WasteCategories addNewCategory(@RequestBody WasteCategories category){
        return wasteCategoryService.addNewCategory(category);
    }
}
