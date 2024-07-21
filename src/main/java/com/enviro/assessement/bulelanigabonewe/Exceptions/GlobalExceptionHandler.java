package com.enviro.assessement.bulelanigabonewe.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.enviro.assessement.bulelanigabonewe.Models.ErrorInfo;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(WasteCategoryNotFoundException.class)
    public ResponseEntity<ErrorInfo> handleWasteCategoryNotFoundException(WasteCategoryNotFoundException ex) {
        ErrorInfo errorResponse = new ErrorInfo(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(DisposalGuidelineNotFoundException.class)
    public ResponseEntity<ErrorInfo> handleDisposalGuidelineNotFoundException(DisposalGuidelineNotFoundException ex) {
        ErrorInfo errorResponse = new ErrorInfo(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(RecyclingTipNotFoundException.class)
    public ResponseEntity<ErrorInfo> handleRecyclingTipNotFoundException(RecyclingTipNotFoundException ex) {
        ErrorInfo errorResponse = new ErrorInfo(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

}
