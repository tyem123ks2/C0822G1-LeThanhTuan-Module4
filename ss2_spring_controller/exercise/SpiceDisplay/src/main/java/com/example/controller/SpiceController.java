package com.example.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpiceController {
    @GetMapping("/sandwich-display")
    public String sandwichForm() {
        return "display";
    }

    @GetMapping("select-spice")
    public String displaySelect(Model model, @RequestParam("condiment") String[] condiment){
        model.addAttribute("condiment", condiment);
        return "result";
    }
}
