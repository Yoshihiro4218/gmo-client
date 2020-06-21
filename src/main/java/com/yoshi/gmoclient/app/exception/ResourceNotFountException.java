package com.yoshi.gmoclient.app.exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFountException extends RuntimeException{
    public ResourceNotFountException(String resource) {
        super("Resource: %s is not found.");
    }
}
