package com.enviro.assessement.bulelanigabonewe.Models;

import lombok.Data;

@Data
public class Response {
    private int statusCode;
    private String message;
    private ResponseType type;

    public Response(int statusCode, String message, ResponseType type) {
        this.statusCode = statusCode;
        this.message = message;
        this.type = type;
    }
}
