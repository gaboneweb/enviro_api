package com.enviro.assessement.bulelanigabonewe.Models;

import lombok.Data;

@Data
public class ErrorInfo {
    private int statusCode;
    private String message;

    public ErrorInfo(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
