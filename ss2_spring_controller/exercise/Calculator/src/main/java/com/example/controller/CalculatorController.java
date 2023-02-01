package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/calculator-form")
    public String showCalculator(Model model) {
        return "calculator";
    }

    @GetMapping("/calculator")
    public String calculation(Model model, @RequestParam("num1") int num1, @RequestParam("num2") int num2, @RequestParam("operator") String operator) {
        String result = null;
        switch (operator) {
            case "Addition(+)":
                result = String.valueOf(num1 + num2);
                break;
            case "Subtraction(-)":
                result = String.valueOf(num1 - num2);
                break;
            case "Multiplication(*)":
                result = String.valueOf(num1 * num2);
                break;
            case "Division(/)":
                if (num2==0){
                    result = "Cannot be divided by 0";
                } else {
                    result = String.valueOf(num1 / num2);
                }
                break;
            default:
                result = null;
        }
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("result", result);
        return "calculator";
        }
}
