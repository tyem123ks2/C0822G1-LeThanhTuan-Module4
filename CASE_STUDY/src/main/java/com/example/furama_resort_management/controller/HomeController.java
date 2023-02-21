package com.example.furama_resort_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class HomeController {

    @GetMapping(value = "")
    public String showHomePage() {
        return "home/home";
    }
}