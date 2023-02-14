package com.example.shopping_cart.controller;

import com.example.shopping_cart.model.Cart;
import com.example.shopping_cart.model.Product;
import com.example.shopping_cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping(value = "/show-shop")
    public String showShop(Model model){
       List<Product> products = (List<Product>) productService.findAll();
        model.addAttribute("products", products);
        return "/shop";
    }

    @GetMapping(value = "/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()){
            return "/error404";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
          cart.addProduct(productOptional.get());
        return "/redirect:/shop";
    }

}
