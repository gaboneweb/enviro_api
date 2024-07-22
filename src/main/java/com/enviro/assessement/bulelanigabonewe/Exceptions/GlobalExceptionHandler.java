package com.enviro.assessement.bulelanigabonewe.Exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.enviro.assessement.bulelanigabonewe.Models.Response;
import com.enviro.assessement.bulelanigabonewe.Models.ResponseType;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(WasteCategoryNotFoundException.class)
    public ResponseEntity<Response> handleWasteCategoryNotFoundException(WasteCategoryNotFoundException ex) {
        Response errorResponse = new Response(HttpStatus.NOT_FOUND.value(), ex.getMessage(), ResponseType.ERROR);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    
    @ExceptionHandler(DisposalGuidelineNotFoundException.class)
    public ResponseEntity<Response> handleDisposalGuidelineNotFoundException(DisposalGuidelineNotFoundException ex) {
        Response errorResponse = new Response(HttpStatus.NOT_FOUND.value(), ex.getMessage(), ResponseType.ERROR);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }


    @ExceptionHandler(RecyclingTipNotFoundException.class)
    public ResponseEntity<Response> handleRecyclingTipNotFoundException(RecyclingTipNotFoundException ex) {
        Response errorResponse = new Response(HttpStatus.NOT_FOUND.value(), ex.getMessage(), ResponseType.ERROR);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }


    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Response> handleIllegalArgumentException(IllegalArgumentException ex){
        Response errorResponse = new Response(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), ResponseType.ERROR);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }


    @ExceptionHandler(InvalidEntityException.class)
    public ResponseEntity<Response> handleInvalidEntityException(InvalidEntityException ex){
        Response errorResponse = new Response(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), ResponseType.ERROR);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }


    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Response> handleDataIntegrityViolationException(DataIntegrityViolationException ex){
        Response errorResponse = new Response(HttpStatus.BAD_REQUEST.value(), "Could not execute statement due to invalid id", ResponseType.ERROR);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Response>> handleValidationException(MethodArgumentNotValidException ex) {

        List<Response> validationErrors = new ArrayList<>();
        
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String message=error.getDefaultMessage();
            validationErrors.add(new Response(HttpStatus.BAD_REQUEST.value(), message, ResponseType.ERROR));
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationErrors);
   
    }

}
