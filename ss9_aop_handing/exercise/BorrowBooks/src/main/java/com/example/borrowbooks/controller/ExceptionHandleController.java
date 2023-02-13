package com.example.borrowbooks.controller;

import com.example.borrowbooks.exception.InvalidCodeException;
import com.example.borrowbooks.exception.OutOfBooksException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandleController {
    @ExceptionHandler(InvalidCodeException.class)
    public String errorPage(){
        return "/error1";
    }

    @ExceptionHandler(OutOfBooksException.class)
    public String errorPage1() {
        return "/error2";
    }
}
