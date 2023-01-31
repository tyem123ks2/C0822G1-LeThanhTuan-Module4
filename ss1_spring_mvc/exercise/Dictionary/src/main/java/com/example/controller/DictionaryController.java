package com.example.controller;

import com.example.service.impl.DictionaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Map;

@Controller
public class DictionaryController {
    private DictionaryService dictionaryService = new DictionaryService();

    @RequestMapping("/dictionary-form")
    public String showDictionary(Model model){
        Map<String,String> map = dictionaryService.getAllVocal();
        model.addAttribute("map",map);
        return "dictionary";
    }

    @RequestMapping("/dictionary")
    public String translate(Model model, String word){
        model.addAttribute("word",word);
        model.addAttribute("meaning", dictionaryService.translate(word));
        return "dictionary";
    }


}
