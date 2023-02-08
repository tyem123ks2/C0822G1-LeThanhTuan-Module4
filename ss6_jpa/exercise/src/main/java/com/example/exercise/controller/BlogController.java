package com.example.exercise.controller;

import com.example.exercise.model.Blog;
import com.example.exercise.service.IBlogService;
import com.example.exercise.service.impl.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {


    @Autowired
    private IBlogService blogService;

    @GetMapping(value = "/show-list")
    public String showList(Model model) {
        List<Blog> blogList = blogService.showAllBlog();
        model.addAttribute("blogList", blogList);
        Blog blog = new Blog();
        model.addAttribute("blog", blog);
        return "blog/list";
    }

    @GetMapping(value = "/detail/{id}")
    public String showDetail(Model model, @PathVariable("id") int id) {
        Optional<Blog> blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "blog/detail";
    }

    @GetMapping(value = "/show-add-form")
    public String showAddForm(Model model) {
        Blog blog = new Blog();
        model.addAttribute("blog", blog);
        return "blog/add";
    }

    @PostMapping(value = "/add")
    public String addNewBlog(Blog blog, RedirectAttributes redirectAttributes) {
        boolean check = blogService.addNewBlog(blog);
        String message;
        if (check) {
            message = "Thêm mới Blog thành công!!";
        } else {
            message = "Thêm mới thất bại!";
        }
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/show-list";
    }

    @GetMapping(value = "/show-edit/{id}")
    public String showEditBlog(Model model, @PathVariable("id") int id) {
        Optional<Blog> blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "blog/edit";
    }

    @PostMapping(value = "/edit")
    public String editBlog(Blog blog, RedirectAttributes redirectAttributes) {
        boolean check = blogService.updateBlog(blog);
        String message;
        if (check) {
            message = "Chính sửa Blog thành công !!";
        } else {
            message = "Chỉnh sửa thất bại!";
        }
        redirectAttributes.addFlashAttribute("message", message);
        return "/redirect:/show-list";
    }

    @GetMapping(value = "/delete")
    public String deleteBlog(Blog blog, RedirectAttributes redirectAttributes) {
        boolean check = blogService.removeBlog(blog.getId());
        String message;
        if (check) {
            message = "Xóa Blog thành công !!";
        } else {
            message = "Xóa Blog thất bại!";
        }
        redirectAttributes.addFlashAttribute("message", message);
        return "/redirect:/list";
    }
}
