package com.example.exercise.controller;

import com.example.exercise.model.Blog;
import com.example.exercise.model.Category;
import com.example.exercise.service.IBlogService;
import com.example.exercise.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping(value = "/show-list")
    public String showList(Model model, @RequestParam(value = "search", defaultValue = "") String search, @PageableDefault(size = 2) Pageable pageable) {
        Page<Blog> blogList = blogService.searchTitle(search, pageable);
        model.addAttribute("blogList", blogList);
        Blog blog = new Blog();
        List<Category> categoryList = categoryService.getAllCategory();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("blog", blog);
        return "blog/list";
    }
    @GetMapping(value = "/show-list/{categoryId}")
    public String findBlogByCategory(Model model,@PathVariable("categoryId") int id, @PageableDefault(size = 2) Pageable pageable) {
        Page<Blog> blogList = blogService.findBlogByCategory(id, pageable);
        model.addAttribute("blogList", blogList);
        Blog blog = new Blog();
        model.addAttribute("blog", blog);
        return "blog/list";
    }

    @GetMapping(value = "/show-detail/{id}")
    public String showDetail(Model model, @PathVariable("id") int id) {
        Optional<Blog> blog = blogService.findBlogById(id);
        model.addAttribute("blog", blog);
        return "blog/detail";
    }

    @GetMapping(value = "/show-add-form")
    public String showAddForm(Model model) {
        Blog blog = new Blog();
        List<Category> categoryList = categoryService.getAllCategory();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("blog", blog);
        return "blog/add";
    }

    @PostMapping(value = "/add")
    public String addNewBlog(RedirectAttributes redirectAttributes, Blog blog) {
        boolean check = blogService.addNewBlog(blog);
        String mess;
        if (check) {
            mess = "Was successfully added";
        } else {
            mess = "Failed to add";
        }
        redirectAttributes.addFlashAttribute("mess", mess);
        return "redirect:/show-list";
    }

    @GetMapping(value = "/show-edit-form/{id}")
    public String showEditForm(Model model, @PathVariable("id") int id) {
        Optional<Blog> blog = blogService.findBlogById(id);
        List<Category> categoryList = categoryService.getAllCategory();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("blog", blog);
        return "blog/edit";
    }

    @PostMapping(value = "/edit")
    public String editBlog(RedirectAttributes redirectAttributes, Blog blog) {
        boolean check = blogService.updateBlog(blog);
        String mess;
        if (check) {
            mess = "Was successfully edited";
        } else {
            mess = "Failed to edit";
        }
        redirectAttributes.addFlashAttribute("mess", mess);
        return "redirect:/show-list";
    }

//    @PostMapping("/delete")
//    public String deleteBlog(RedirectAttributes redirectAttributes, Blog blog) {
//        blog.setDeleted(true);
//        boolean check = blogService.updateBlog(blog);
//        String mess;
//        if (check) {
//            mess = "Was successfully deleted";
//        } else {
//            mess = "Failed to delete";
//        }
//        redirectAttributes.addFlashAttribute("mess", mess);
//        return "redirect:/show-list";

}
