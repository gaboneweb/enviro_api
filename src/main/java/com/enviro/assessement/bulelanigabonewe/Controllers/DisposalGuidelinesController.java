package com.enviro.assessement.bulelanigabonewe.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enviro.assessement.bulelanigabonewe.Services.DisposalGuidelinesService;
import com.enviro.assessement.bulelanigabonewe.Exceptions.DisposalGuidelineNotFoundException;
import com.enviro.assessement.bulelanigabonewe.Models.DisposalGuidelines;
import com.enviro.assessement.bulelanigabonewe.Models.Response;
import com.enviro.assessement.bulelanigabonewe.Models.ResponseType;

@RestController
@RequestMapping("/guidelines")
public class DisposalGuidelinesController {

    private final DisposalGuidelinesService disposalGuidelinesService;

    @Autowired
    public DisposalGuidelinesController(DisposalGuidelinesService disposalGuidelinesService){
        this.disposalGuidelinesService = disposalGuidelinesService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<DisposalGuidelines> getGuidelinesById(@PathVariable Long id){
        Optional<DisposalGuidelines> guidleine = disposalGuidelinesService.getGuidelinesById(id);
        if(guidleine.isPresent()){
            return ResponseEntity.ok(guidleine.get());
        }

        throw new DisposalGuidelineNotFoundException(id);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<DisposalGuidelines>> getGuidelinesByCategoryId(@PathVariable Long categoryId){
        return ResponseEntity.ok(disposalGuidelinesService.getGuidelinesByCategoryId(categoryId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteTipById(@PathVariable Long id){
        disposalGuidelinesService.deleteGuidelinepById(id);;
        Response response = new Response(HttpStatus.OK.value(), "Disposal guideline deleted, id:  " + id, ResponseType.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @DeleteMapping("/category/{categoryId}")
    public ResponseEntity<Response> deleteGuidelinesByCategoryId(@PathVariable Long categoryId){
        disposalGuidelinesService.deleteGuidelinesCategoryById(categoryId);
        Response response = new Response(HttpStatus.OK.value(), "Disposal guidelines deleted, category id:  " + categoryId, ResponseType.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }






}
