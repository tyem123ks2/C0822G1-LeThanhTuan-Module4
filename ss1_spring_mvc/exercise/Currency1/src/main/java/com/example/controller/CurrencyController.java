package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {
    @GetMapping("/converter-form")
    public String showConverter(Model model) {
        return "converter";
    }

    @GetMapping("/converter")
    public String converter(Model model, @RequestParam("usd") double usd){
        model.addAttribute("usd", usd);
        model.addAttribute("vnd", 23000*usd);
        return "converter";
    }
}
