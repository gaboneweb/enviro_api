package com.enviro.assessement.bulelanigabonewe.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.enviro.assessement.bulelanigabonewe.Exceptions.RecyclingTipNotFoundException;
import com.enviro.assessement.bulelanigabonewe.Models.RecyclingTips;
import com.enviro.assessement.bulelanigabonewe.Models.Response;
import com.enviro.assessement.bulelanigabonewe.Models.ResponseType;
import com.enviro.assessement.bulelanigabonewe.RequestDTOs.RecyclingTipsDTO;
import com.enviro.assessement.bulelanigabonewe.Services.RecyclingTipsService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/tips")
public class RecyclingTipsController {

    private final RecyclingTipsService recyclingTipsService;


    @Autowired
    public RecyclingTipsController(RecyclingTipsService recyclingTipsService){
        this.recyclingTipsService = recyclingTipsService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTips> getCategotiesById(@PathVariable Long id){
        Optional<RecyclingTips> tips = recyclingTipsService.getRecyclingTipById(id);

        if(tips.isPresent()){
            return ResponseEntity.ok(tips.get());
        }

        throw new RecyclingTipNotFoundException(id);
        
    }


    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<RecyclingTips>> getRecyclingTipsByCategoryId(@PathVariable Long categoryId){
        return ResponseEntity.ok(recyclingTipsService.getRecyclingTipByCategoryId(categoryId));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteTipById(@PathVariable Long id){
        recyclingTipsService.deleteTipById(id);
        Response response = new Response(HttpStatus.OK.value(), "Recycling tip deleted, id:  " + id, ResponseType.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @DeleteMapping("/category/{categoryId}")
    public ResponseEntity<Response> deleteRecyclingTipsByCategoryId(@PathVariable Long categoryId){
        recyclingTipsService.deleteTipsCategoryById(categoryId);
        Response response = new Response(HttpStatus.OK.value(), "Recycling tips deleted,category id:  " + categoryId, ResponseType.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @PutMapping("/")
    public ResponseEntity<RecyclingTips> updateDisposalGuideline(@RequestBody @Valid RecyclingTipsDTO tip ){
        return ResponseEntity.ok(recyclingTipsService.updateRecyclingTip(tip));
    }

    @PostMapping("/")
    public ResponseEntity<RecyclingTips> addNewDisposalGuideline(@RequestBody @Valid RecyclingTipsDTO tip ){
        return ResponseEntity.ok(recyclingTipsService.addNewRecyclingTip(tip));
    }

}
