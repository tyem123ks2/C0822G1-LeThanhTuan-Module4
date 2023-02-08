package com.example.exercise.controller;

import com.example.exercise.model.Blog;
import com.example.exercise.model.Category;
import com.example.exercise.service.impl.CategoryService;
import net.bytebuddy.TypeCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/show-list")
    public String showListCategory(Model model, @RequestParam(required = false, defaultValue = "")String nameSreach,
                                   @PageableDefault(size = 3, page = 0, sort = "id", direction = Sort.Direction.DESC) Pageable pageable){
        Page<Category> categoryPage = categoryService.findByNameCategory(nameSreach, pageable);
        if (categoryPage.isEmpty()) {
            model.addAttribute("mess", "Không tìm thấy thể loại");
        } else {
            model.addAttribute("categoryPage", categoryPage);
            model.addAttribute("name", nameSreach);
        }
        model.addAttribute("category", new Category());
        return "/list";
    }

    @GetMapping(value = "/detail/{id}")
    public String showDetailCategory(Model model, @PathVariable("id") int id) {
        Optional<Category> category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "/detail";
    }

    @PostMapping(value = "/add")
    public String addNewCategory(Category category, RedirectAttributes redirectAttributes) {
        boolean check = categoryService.addNewCategory(category);
        String message;
        if (check) {
            message = "Thêm mới Category thành công!!";
        } else {
            message = "Thêm mới thất bại!";
        }
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/show-list";
    }

    @GetMapping(value = "/show-edit/{id}")
    public String showEditCategory(Model model, @PathVariable("id") int id) {
        Optional<Category> category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "edit";
    }

    @PostMapping(value = "/edit")
    public String editCategory(Category category, RedirectAttributes redirectAttributes) {
        boolean check = categoryService.updateCategory(category);
        String message;
        if (check) {
            message = "Chính sửa Category thành công !!";
        } else {
            message = "Chỉnh sửa thất bại!";
        }
        redirectAttributes.addFlashAttribute("message", message);
        return "/redirect:/show-list";
    }

    @GetMapping(value = "/delete")
    public String deleteCategoryg(Category category, RedirectAttributes redirectAttributes) {
        boolean check = categoryService.removeCategory(category.getId());
        String message;
        if (check) {
            message = "Xóa Category thành công !!";
        } else {
            message = "Xóa Category thất bại!";
        }
        redirectAttributes.addFlashAttribute("message", message);
        return "/redirect:/list";
    }

}
