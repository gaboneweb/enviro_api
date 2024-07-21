package com.enviro.assessement.bulelanigabonewe.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enviro.assessement.bulelanigabonewe.Exceptions.WasteCategoryNotFoundException;
import com.enviro.assessement.bulelanigabonewe.Models.Response;
import com.enviro.assessement.bulelanigabonewe.Models.ResponseType;
import com.enviro.assessement.bulelanigabonewe.Models.WasteCategories;
import com.enviro.assessement.bulelanigabonewe.Services.WasteCategoryService;

@RestController
@RequestMapping("/categories")
public class WasteCategoryController {
    private final WasteCategoryService wasteCategoryService;

    public WasteCategoryController(WasteCategoryService wasteCategoryService){
        this.wasteCategoryService = wasteCategoryService;
    }


    @GetMapping("/")
    public ResponseEntity<List<WasteCategories>> getAllWasteCategories(){
        return ResponseEntity.ok(wasteCategoryService.getWasteCategories());
    }


    @GetMapping("/{id}")
    public ResponseEntity<WasteCategories> getCategotiesById(@PathVariable Long id){
        Optional<WasteCategories> categories = wasteCategoryService.getWasteCategoryById(id);

        if(categories.isPresent()){
            return ResponseEntity.ok(categories.get());
        }

        throw new WasteCategoryNotFoundException(id);
        
    }


    @PostMapping("/")
    public ResponseEntity<WasteCategories> addNewCategory(@RequestBody WasteCategories category){
        return ResponseEntity.ok(wasteCategoryService.addNewCategory(category));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteCategoryById(@PathVariable Long id){
        wasteCategoryService.deleteCategoryById(id);
        Response response = new Response(HttpStatus.OK.value(), "Category deleted, id:  " + id, ResponseType.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/")
    public ResponseEntity<WasteCategories> updateCategory(@RequestBody WasteCategories category){
        return ResponseEntity.ok(wasteCategoryService.updateCategory(category));
    }
}
