package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("/")
    public String showList(Model model){
        List<Product> productList = iProductService.findAll();
        model.addAttribute("productList", productList);
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product", new Product());
        return "/create";
    }

    @GetMapping("/save")
    public String save(RedirectAttributes redirectAttributes, Product product){
        iProductService.save(product);
        redirectAttributes.addFlashAttribute("message", "ADD NEW PRODUCT SUCCESSFULLY!");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable int id){
        model.addAttribute("product", iProductService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(RedirectAttributes redirectAttributes, Product product){
        iProductService.update(product);
        redirectAttributes.addFlashAttribute("message", "UPDATE PRODUCT SUCCESSFULLY!");
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String delete(Model model, @PathVariable int id){
        model.addAttribute("product", iProductService.findById(id));
        return "/delete";
    }

    @GetMapping("/view/{id}")
    public String view(Model model, @PathVariable int id){
        model.addAttribute(("product"), iProductService.findById(id));
        return "/view";
    }

    @GetMapping("/sreach")
    public String sreach(Model model, @RequestParam String name){
        model.addAttribute("productList", iProductService.findByName(name));
        return "/list";
    }
}
