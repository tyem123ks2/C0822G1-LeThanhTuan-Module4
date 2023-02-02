package com.example.controller;

import com.example.model.Email;
import com.example.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class EmailController {
    @Autowired
    private IEmailService iEmailService;

    @GetMapping("/")
    public String showEmailList(Model model) {
        List<Email> emailList = iEmailService.findAll();
        model.addAttribute("emailList", emailList);
        return "list";
    }

    @GetMapping("/update")
    public String home(@RequestParam int id, Model model) {
        model.addAttribute("email", iEmailService.findById(id));
        model.addAttribute("languageList", iEmailService.findLanguage());
        model.addAttribute("pageSizeList", iEmailService.findPageSize());
        return "form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Email email, RedirectAttributes redirectAttributes) {
        iEmailService.update(email);
        redirectAttributes.addFlashAttribute("mess", "Update Successfully!");
        return "redirect:/";
    }

}
