package com.ultra.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ThrowableHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public String ArguementException(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
        return "400";
    }
}
